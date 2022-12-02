package test_user_registration;

import data_access.Database;
import entities.user_entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.user_registration_use_cases.ISendVerificationCode;
import use_cases.user_registration_use_cases.UserExistsPresenter;
import use_cases.user_registration_use_cases.UserExistsOutputBoundary;
import use_cases.user_registration_use_cases.createMailMan;

public class TestUserExistsInteractor {
    //Objects used for testing
    // The below anonymous database is created to test cases where the user does not exist.
    Database userDontExist = new Database() {
        @Override
        public User getUser(String username) {
            return null;
        }

        @Override
        public void createUser(String username, String password, String email, String type) {

        }

        @Override
        public boolean UserExists(String username, String email) {
            return false;
        }
        @Override
        public boolean UserExists(String username) {
            return false;
        }
    };
    //The below anonymous database for testing cases where the user exists
    Database userExists = new Database() {
        @Override
        public User getUser(String username) {
            return null;
        }

        @Override
        public void createUser(String username, String password, String email, String type) {

        }

        @Override
        public boolean UserExists(String username, String email) {
            return true;
        }

        @Override
        public boolean UserExists(String username) {
            return true;
        }
    };
    //This output boundary used in test cases
    private class TestOutputBoundary implements UserExistsOutputBoundary{
        public int x = 0;
        @Override
        public void getVerificationCredentials() {
            this.x += 1;
        }

        @Override
        public void presentUserExistsMessage() {
            this.x += 3;
        }

        @Override
        public void getCode(int code) {
            this.x += 5;
        }

        @Override
        public void getUserCredentials(String username, String password, String email) {
            this.x += 7;
        }
    }
    TestOutputBoundary userExistsOutputBoundary = new TestOutputBoundary();
    //The verification streams, and verification Stream factory used for testing
    ISendVerificationCode verStream1 = (email, code) -> {

    };
    ISendVerificationCode verStream2 = (email, code) -> {

    };
    private class TestCreateMailMan implements createMailMan{
        public int x;
        @Override
        public ISendVerificationCode getVerificationMethod(String type) {
            if(type.equals("0")){
                x = 100;
                return verStream1;
            }else{
                x = 200;
                return verStream2;
            }
        }
    }
    TestCreateMailMan mailManFactory = new TestCreateMailMan();

    //In the first test, the user exists in the database, and we will set verStream1 as the verification method
    @Test
    public void userExistsInDatabase1(){
        UserExistsPresenter uInteractor = new UserExistsPresenter(userExists,
                userExistsOutputBoundary, mailManFactory);
        uInteractor.setCodeDeliveryMethod("0");
        uInteractor.register("a", "b", "c");
        //The quantity below should be 103
        Assertions.assertEquals(userExistsOutputBoundary.x + mailManFactory.x, 103);

    }
    //In this test, the user does not exist in the database, and we will set verStream2 as the verification method
    @Test
    public void userExistsInDatabase2(){
        TestOutputBoundary userExists2 = new TestOutputBoundary();
        TestCreateMailMan createMailMan2 = new TestCreateMailMan();
        UserExistsPresenter uInteractor2 = new UserExistsPresenter(userDontExist, userExists2, createMailMan2);
        uInteractor2.setCodeDeliveryMethod("1");
        uInteractor2.register("a", "b", "c");
        //The quantity below should be 213
        Assertions.assertEquals(userExists2.x + createMailMan2.x, 213);

    }

    //No other combinations of the method calls, could arrive at those values, so the above tests passing suffices
}
