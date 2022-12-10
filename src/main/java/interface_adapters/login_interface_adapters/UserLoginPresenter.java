package interface_adapters.login_interface_adapters;

import data_access.Database;
import use_cases.user_login_use_cases.UserLoginInputBoundary;
/**
 * Presenter object that gets info from the view, and passes it to the login use case objects in order
 * to implement login
 * **/
public class UserLoginPresenter {
    private final UserLoginInputBoundary loginGuard;
    private String username;
    private String password;
    Database database;
    private UserLoginViewI loginView;

    public UserLoginPresenter(Database database, UserLoginInputBoundary loginGuard){
        //TODO: this object does not use this.database, so must change the arguments.
        this.database = database;
        this.loginGuard = loginGuard;
    }
    /**
     * Passes info from the view into loginInteractor(use case interactor object)
     **/
    public void tryLogin() {
        loginGuard.login(this.username, this.password);
        loginView.setChatsPresenter(loginGuard.getChatsPresenter());
        loginView.display();
    }
    /**
     * Gets the info from the view
     * **/
    public void setLoginCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public void setLoginCredentials(String username){
        this.username = username;
    }
    /**
     * Sets the screen that will update the view after login
     **/
    public void setLoginView(UserLoginViewI loginView){
        this.loginView = loginView;
    }


    public void tryLoginNoPassword() {
        loginGuard.loginNoPassword(this.username);
        loginView.setChatsPresenter(loginGuard.getChatsPresenter());
        loginView.display();
    }
}
