package interface_adapters.user_registration_interface_adapters;

import data_access.Database;
import screens.login_screen.UserLoginUI;
import use_cases.user_login_use_cases.loginCredentialsRetriever;
import use_cases.user_registration_use_cases.userRegistrationOutputBoundary;

import javax.swing.*;

public class UserRegistrationPresenter implements userRegistrationOutputBoundary {
    @Override
    public void accountExistsMessage(){
        JFrame accountExistsFrame = new JFrame();
        accountExistsFrame.setSize(400, 100);
        accountExistsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel accountExistsPanel = new JPanel();
        accountExistsPanel.setLayout(null);
        accountExistsFrame.add(accountExistsPanel);
        JLabel errorMessage = new JLabel("An account with this username or email already exists");
        errorMessage.setBounds(10,20, 350, 20);
        accountExistsPanel.add(errorMessage);
        accountExistsFrame.setVisible(true);
    }
    @Override
    public void verificationSuccessMessage(String message){
        JFrame verificationSuccessFrame = new JFrame();
        verificationSuccessFrame.setSize(400, 100);
        verificationSuccessFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel verificationSuccessPanel = new JPanel();
        verificationSuccessPanel.setLayout(null);
        verificationSuccessFrame.add(verificationSuccessPanel);
        JLabel errorMessage = new JLabel(message);
        errorMessage.setBounds(10,20, 350, 20);
        verificationSuccessPanel.add(errorMessage);
        verificationSuccessFrame.setVisible(true);
    }
    @Override
    public void registrationSuccessAction(Database database){
        loginCredentialsRetriever loginUI = new UserLoginUI(database);
        loginUI.getLoginCredentials();
    }
}
