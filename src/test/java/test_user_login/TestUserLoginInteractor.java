package test_user_login;

import data_access.UserDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.user_login_use_cases.UserLoginInteractor2;
import use_cases.user_login_use_cases.UserLoginOutputBoundary;

import java.io.File;
import java.util.List;

public class TestUserLoginInteractor {
    private final UserDatabase database = new UserDatabase(new File("testAccounts"));
    private static class testUserChatsPresenter implements UserLoginOutputBoundary{
        public int x;
        private boolean notExists;
        private boolean notMatched;

        @Override
        public void setUsername(String username) {
            x += 1;
        }

        @Override
        public void setChats(List<String> chats) {
            x += 3;
        }

        @Override
        public void setUserNotExists(boolean notExists) {
            this.notExists = notExists;
        }

        @Override
        public void setPasswordNotMatched(boolean notMatched) {
            this.notMatched = notMatched;
        }

        @Override
        public String getUsername() {
            return null;
        }

        @Override
        public List<String> getChats() {
            return null;
        }

        @Override
        public boolean isNotExists() {
            return this.notExists;
        }

        @Override
        public boolean isNotMatched() {
            return this.notMatched;
        }
    }

    @Test
    public void testUserNotExists(){
        testUserChatsPresenter chatsPresenter = new testUserChatsPresenter();
        UserLoginInteractor2 userInteractor = new UserLoginInteractor2(database, chatsPresenter);
        userInteractor.login("Madhavi", "123");
        Assertions.assertTrue(chatsPresenter.isNotExists());
    }

    @Test
    public void testUserPasswordWrong(){
        testUserChatsPresenter chatsPresenter = new testUserChatsPresenter();
        UserLoginInteractor2 userInteractor = new UserLoginInteractor2(database, chatsPresenter);
        database.createUser("Madhav", "123", "madhavgopan2000@gmail.com", "Basic");
        userInteractor.login("Madhav", "1234");
        Assertions.assertFalse(chatsPresenter.isNotExists());
        Assertions.assertTrue(chatsPresenter.isNotMatched());
    }
    @Test
    public void testUserPasswordRightUserExists(){
        testUserChatsPresenter chatsPresenter = new testUserChatsPresenter();
        UserLoginInteractor2 userInteractor = new UserLoginInteractor2(database, chatsPresenter);
        userInteractor.login("Madhav", "123");
        Assertions.assertFalse(chatsPresenter.isNotExists());
        Assertions.assertFalse(chatsPresenter.isNotMatched());
        //To make sure that setting chats and username is done right.
        Assertions.assertEquals(chatsPresenter.x, 4);
    }

}
