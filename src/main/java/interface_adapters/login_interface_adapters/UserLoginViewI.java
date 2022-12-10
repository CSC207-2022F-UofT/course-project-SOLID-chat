package interface_adapters.login_interface_adapters;

import use_cases.user_login_use_cases.UserLoginOutputBoundary;
/**
 * ViewInterface that will update the view after login
 * **/
public interface UserLoginViewI {
    void display();
    void setChatsPresenter(UserLoginOutputBoundary outputBoundary);
}
