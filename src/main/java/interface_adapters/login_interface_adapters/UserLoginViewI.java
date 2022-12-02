package interface_adapters.login_interface_adapters;

import use_cases.user_login_use_cases.UserLoginOutputBoundary;

public interface UserLoginViewI {
    void display();
    void setChatsPresenter(UserLoginOutputBoundary outputBoundary);
}
