package test_user_login;

import data_access.Database;
import entities.user_entities.User;
import interface_adapters.login_interface_adapters.UserLoginPresenter;
import interface_adapters.login_interface_adapters.UserLoginViewI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.user_login_use_cases.UserLoginInputBoundary;
import use_cases.user_login_use_cases.UserLoginOutputBoundary;

public class TestUserLoginPresenter {
    //creating the objects used for testing
    private static class TestDB implements Database{

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
    }
    private static class TestLoginIB implements UserLoginInputBoundary{
        public int x = 0;
        @Override
        public void login(String username, String password) {
            this.x += 3;
        }

        @Override
        public UserLoginOutputBoundary getChatsPresenter() {
            this.x += 5;
            return null;
        }

        @Override
        public void loginNoPassword(String username) {
            this.x += 7;
        }
    }

    private static class TestLoginViewI implements UserLoginViewI{
        public int x = 0;
        @Override
        public void display() {
            this.x += 100;
        }

        @Override
        public void setChatsPresenter(UserLoginOutputBoundary outputBoundary) {
            this.x += 200;
        }
    }

    Database testDB = new TestDB();
    TestLoginIB loginInputBoundary = new TestLoginIB();
    TestLoginViewI loginViewI = new TestLoginViewI();
    UserLoginPresenter loginPresenter = new UserLoginPresenter(testDB, loginInputBoundary);

    /*
    Below is the only test needed, as these tests are just checking if the methods are called, correctness of the use
    case now depends on how the objects it takes in are implemented
    */
    @Test
    void onlyTest(){
        loginPresenter.setLoginView(loginViewI);
        loginPresenter.tryLogin();
        Assertions.assertEquals(loginInputBoundary.x + loginViewI.x, 308);
    }
}
