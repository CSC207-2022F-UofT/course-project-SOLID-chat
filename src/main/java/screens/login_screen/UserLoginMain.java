package screens.login_screen;

import data_access.Database;
import data_access.UserDatabase;
import interface_adapters.login_interface_adapters.UserChatsPresenter;
import interface_adapters.login_interface_adapters.UserLoginPresenter;
import use_cases.user_login_use_cases.UserLoginInputBoundary;
import use_cases.user_login_use_cases.UserLoginInteractor2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginMain implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Database userDB = new UserDatabase();
        UserLoginInputBoundary inputBoundary = new UserLoginInteractor2(userDB, new UserChatsPresenter());
        UserLoginPresenter loginPresenter1 = new UserLoginPresenter(userDB, inputBoundary);
        UserLoginUI loginUI = new UserLoginUI(loginPresenter1);
        loginUI.getLoginCredentials();
    }
}
