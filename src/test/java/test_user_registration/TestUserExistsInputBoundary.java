package test_user_registration;

import data_access.Database;
import entities.user_entities.User;
import org.junit.jupiter.api.Test;
import use_cases.user_registration_use_cases.UserExistsOutputBoundary;

public class TestUserExistsInputBoundary {
    @Test
    public void invalidCredentials(){
        //Anonymous class
        Database testDB = new Database() {
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
        //Anonymous class for outputBoundary
        UserExistsOutputBoundary outputBoundary = new UserExistsOutputBoundary() {
            public int x;
            @Override
            public void getVerificationCredentials() {
                x += 1;
            }

            @Override
            public void presentUserExistsMessage() {
                x += 3;
            }

            @Override
            public void getCode(int code) {
                x += 5;
            }

            @Override
            public void getUserCredentials(String username, String password, String email) {
                x += 6;
            }
        };





    }
}
