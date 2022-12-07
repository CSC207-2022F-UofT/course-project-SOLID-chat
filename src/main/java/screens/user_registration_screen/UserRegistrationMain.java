package screens.user_registration_screen;

import data_access.Database;
import data_access.UserDatabase;
import interface_adapters.login_interface_adapters.ForgotPasswordPresenter;
import interface_adapters.login_interface_adapters.UserChatsPresenter;
import interface_adapters.login_interface_adapters.UserLoginPresenter;
import interface_adapters.user_registration_interface_adapters.UserExistsOutputView;
import interface_adapters.user_registration_interface_adapters.UserExistsPresenter;
import interface_adapters.user_registration_interface_adapters.UserVerificationOutputView;
import interface_adapters.user_registration_interface_adapters.UserVerificationPresenter;
import screens.login_screen.UserLoginUI;
import use_cases.user_login_use_cases.UserLoginInteractor2;
import use_cases.user_registration_use_cases.EmailDelivery;
import use_cases.user_registration_use_cases.verificationMethodFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserRegistrationMain implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        Database testDB = new UserDatabase();
        UserLoginInteractor2 userLoginInteractor2 = new UserLoginInteractor2(testDB, new UserChatsPresenter());
        UserLoginPresenter userLoginPresenter = new UserLoginPresenter(testDB, userLoginInteractor2);
        //Objects related to forgotten password
        EmailDelivery emailDelivery = new EmailDelivery();
        ForgotPasswordPresenter forgotPasswordPresenter = new ForgotPasswordPresenter(userLoginPresenter,
                userLoginInteractor2, emailDelivery);
        UserVerificationOutputView loginUI = new UserLoginUI(userLoginPresenter, forgotPasswordPresenter);
        UserVerificationPresenter verificationInteractor = new UserVerificationPresenter(testDB, loginUI);
        UserExistsOutputView verificationScreen = new UserVerificationScreen(verificationInteractor);
        UserExistsPresenter existsInteractor = new UserExistsPresenter(testDB, verificationScreen, new verificationMethodFactory());
        UserRegistrationUI testUI = new UserRegistrationUI(existsInteractor);
        testUI.getUserCredentials();
    }
}
