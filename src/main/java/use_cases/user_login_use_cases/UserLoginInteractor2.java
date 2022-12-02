package use_cases.user_login_use_cases;

import data_access.Database;
import entities.user_entities.User;

import java.util.ArrayList;

public class UserLoginInteractor2 implements UserLoginInputBoundary {
    private final UserLoginOutputBoundary chatPresenter;
    private final Database database;

    private User user;

    public UserLoginInteractor2(Database database, UserLoginOutputBoundary chatPresenter){
        this.database = database;
        this.chatPresenter = chatPresenter;
    }

    @Override
    public void login(String username, String password) {
        //will update this.chatPresenter
        //TODO: change below, as its just temporary
        user = database.getUser(username);


    }

    @Override
    public UserLoginOutputBoundary getChatsPresenter() {
        return this.chatPresenter;
    }
}
