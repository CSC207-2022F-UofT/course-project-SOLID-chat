package screens.login_screen;
import use_cases.user_login_use_cases.UserLoginInputBoundary;
import use_cases.user_registration_use_cases.UserVerificationOutputBoundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** This is the screen on which the user enters his credentials in order to login **/
public class UserLoginUI implements ActionListener, UserVerificationOutputBoundary {

    private final UserLoginInputBoundary loginInteractor;
    JTextField credentialText;
    JPasswordField passwordText;

    public UserLoginUI(UserLoginInputBoundary loginInteractor){
        this.loginInteractor = loginInteractor;
    }
    @Override
    public void getLoginCredentials(){
        JFrame loginFrame = new JFrame();
        loginFrame.setSize(400, 400);
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel loginPanel = new JPanel();
        loginFrame.add(loginPanel);

        loginPanel.setLayout(null);
        JLabel credentialLabel = new JLabel("Enter username/email:");
        credentialLabel.setBounds(10,25, 200, 25);
        credentialText = new JTextField();
        credentialText.setBounds(210, 25, 100, 25);

        loginPanel.add(credentialLabel);
        loginPanel.add(credentialText);

        JLabel passwordLabel = new JLabel("Enter Password:");
        passwordLabel.setBounds(10,55, 200, 25);
        passwordText = new JPasswordField();
        passwordText.setBounds(210, 55, 100, 25);

        loginPanel.add(passwordLabel);
        loginPanel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(210, 95, 100, 25);
        loginPanel.add(loginButton);
        loginButton.addActionListener(this);
        loginFrame.setVisible(true);

    }

    @Override
    public void cannotVerify() {
        JFrame cannotVerifyFrame = new JFrame();
        cannotVerifyFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        cannotVerifyFrame.setSize(400, 100);
        JPanel cannotVerifyPanel = new JPanel();
        cannotVerifyPanel.setLayout(null);
        cannotVerifyFrame.add(cannotVerifyPanel);

        JLabel cannotVerifyLabel = new JLabel("Incorrect verification code, please try again");
        cannotVerifyLabel.setBounds(10, 25, 350, 30);
        cannotVerifyPanel.add(cannotVerifyLabel);
        cannotVerifyFrame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = credentialText.getText();
        String password = passwordText.getText();
        loginInteractor.setLoginCredentials(username, password);
        loginInteractor.tryLogin();
    }
}
