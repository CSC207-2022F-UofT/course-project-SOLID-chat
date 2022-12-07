package screens.login_screen;

import data_access.Database;
import data_access.UserDatabase;
import interface_adapters.login_interface_adapters.ForgotPasswordPresenter;
import interface_adapters.login_interface_adapters.UserChatsPresenter;
import interface_adapters.login_interface_adapters.UserLoginPresenter;
import use_cases.user_login_use_cases.RetrieveEmail;
import use_cases.user_login_use_cases.UserLoginInputBoundary;
import use_cases.user_login_use_cases.UserLoginInteractor2;
import use_cases.user_registration_use_cases.EmailDelivery;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserLoginMain implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        EmailDelivery emailDelivery = new EmailDelivery();
        //Setting up login
        Database userDB = new UserDatabase();
        //This is also a RetrieveEmail object
        UserLoginInputBoundary inputBoundary = new UserLoginInteractor2(userDB, new UserChatsPresenter());
        UserLoginPresenter loginPresenter1 = new UserLoginPresenter(userDB, inputBoundary);
        //Creating objects related to forgotten password
        ForgotPasswordPresenter forgotPasswordPresenter = new ForgotPasswordPresenter(loginPresenter1,
                (RetrieveEmail)inputBoundary, emailDelivery);
        UserLoginUI loginUI = new UserLoginUI(loginPresenter1, forgotPasswordPresenter);
        loginUI.getLoginCredentials();
    }
}
