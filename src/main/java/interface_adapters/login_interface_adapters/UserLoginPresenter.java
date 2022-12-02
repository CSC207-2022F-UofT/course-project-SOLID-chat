package interface_adapters.login_interface_adapters;

import data_access.Database;
import use_cases.user_login_use_cases.UserLoginInputBoundary;

public class UserLoginPresenter {
    private final UserLoginInputBoundary loginGuard;
    private String username;
    private String password;
    Database database;
    private UserLoginViewI loginView;

    public UserLoginPresenter(Database database, UserLoginInputBoundary loginGuard){
        this.database = database;
        this.loginGuard = loginGuard;
    }

    public void tryLogin() {
        loginGuard.login(this.username, this.password);
        loginView.setChatsPresenter(loginGuard.getChatsPresenter());
        loginView.display();
    }

    public void setLoginCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void setLoginView(UserLoginViewI loginView){
        this.loginView = loginView;
    }

}
