package screens.login_screen;
import interface_adapters.login_interface_adapters.ForgotPasswordPresenter;
import interface_adapters.login_interface_adapters.UserLoginViewI;
import interface_adapters.login_interface_adapters.UserLoginPresenter;
import interface_adapters.user_registration_interface_adapters.UserVerificationOutputView;
import screens.user_registration_screen.ViewHelper;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** This is the screen on which the user enters his credentials in order to login **/
public class UserLoginUI implements ActionListener, UserVerificationOutputView {

    private final UserLoginPresenter loginPresenter;
    private final ForgotPasswordPresenter forgotPasswordPresenter;
    JTextField credentialText;
    JPasswordField passwordText;
    //Ignoring the below warning, just incase we add more buttons
    private JButton forgotPassword;
    private JButton loginButton;

    public UserLoginUI(UserLoginPresenter loginPresenter, ForgotPasswordPresenter forgotPasswordPresenter){
        UserLoginViewI loginViewI = new AppScreenCreator();
        this.loginPresenter = loginPresenter;
        this.loginPresenter.setLoginView(loginViewI);
        //Related to Forgotten Password
        this.forgotPasswordPresenter = forgotPasswordPresenter;
    }
    /**
     * Frame to input login credentials
     * **/
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

        loginButton = new JButton("login");
        loginButton.setBounds(210, 95, 100, 25);
        loginPanel.add(loginButton);
        loginButton.addActionListener(this);

        forgotPassword = new JButton("forgot password?");
        forgotPassword.setBounds(210, 120, 150, 25);
        loginPanel.add(forgotPassword);
        forgotPassword.addActionListener(this);
        loginFrame.setVisible(true);

    }
    /**
     * If the verification code is not right, this message shows up
     * TODO: this has nothing to do with entering login credentials, so this is a violation of Interface segregation
     *  principles
     *  **/
    @Override
    public void cannotVerify() {
        ViewHelper.simpleMessage("Incorrect verification code, please try again", 350);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = credentialText.getText();
        if(e.getSource().equals(loginButton)){
        String password = passwordText.getText();
        loginPresenter.setLoginCredentials(username, password);
        loginPresenter.tryLogin();
        } else{
            System.out.println("forgot password");
            forgotPasswordPresenter.setUsername(username);
            ForgotPasswordScreen forgotPasswordScreen = new ForgotPasswordScreen(this.forgotPasswordPresenter);
            forgotPasswordScreen.getEntryCode();
        }
    }
}
