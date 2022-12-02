package test_user_registration;

import data_access.Database;
import entities.user_entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import interface_adapters.user_registration_interface_adapters.UserVerificationPresenter;
import interface_adapters.user_registration_interface_adapters.UserVerificationOutputView;

public class TestUserVerificationInteractor {
    private class testDatabase implements Database{
        public int x;
        @Override
        public User getUser(String username) {
            return null;
        }

        @Override
        public void createUser(String username, String password, String email, String type) {
            x += 1;
        }

        @Override
        public boolean UserExists(String username, String email) {
            return false;
        }

        @Override
        public boolean UserExists(String username) {
            return false;
        }
    }
    private class testUserVerificationOutputBdy implements UserVerificationOutputView {
        public int x;
        @Override
        public void getLoginCredentials() {
            x += 20;
        }

        @Override
        public void cannotVerify() {
            x+= 30;
        }
    }
    //objects used for test
    testDatabase testDB = new testDatabase();
    testUserVerificationOutputBdy userVerificationOutputBdy = new testUserVerificationOutputBdy();
    //The below test is to see if the verify function works in the case that the code is not right
    @Test
    public void testCodeNotRight(){
        UserVerificationPresenter testInteractor = new UserVerificationPresenter(testDB, userVerificationOutputBdy);

        testInteractor.setCode(123);
        testInteractor.setCredentials("a", "b", "c");
        testInteractor.verify(135);
        Assertions.assertEquals(testDB.x + userVerificationOutputBdy.x, 30);
    }
    //The below test is to see if the verify function works in the case that the code is right
    @Test
    public void testCodeRight(){
        UserVerificationPresenter testInteractor = new UserVerificationPresenter(testDB, userVerificationOutputBdy);

        testInteractor.setCode(123);
        testInteractor.setCredentials("a", "b", "c");
        testInteractor.verify(123);
        Assertions.assertEquals(testDB.x + userVerificationOutputBdy.x, 21);
    }
}
