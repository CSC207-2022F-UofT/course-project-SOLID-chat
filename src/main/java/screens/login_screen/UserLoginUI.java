package screens.login_screen;
import data_access.Database;
import use_cases.user_login_use_cases.UserLoginInteractor;
import interface_adapters.login_interface_adapters.UserLoginGateway;
import data_access.UserDatabase;
import use_cases.user_login_use_cases.loginCredentialsRetriever;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
/** This is the screen on which the user enters his credentials in order to login **/
public class UserLoginUI implements ActionListener, loginCredentialsRetriever {

    private JTextField credentialText;
    private JLabel passwordLabel;
    private JPasswordField passwordText;

    private final Database database;

    public UserLoginUI(Database database){
        this.database = database;
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

        passwordLabel = new JLabel("Enter Password:");
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

    public static void main(String[] args){
        Database testDB = new UserDatabase(new File("user_accounts"));
        UserLoginUI screen = new UserLoginUI(testDB);
        screen.getLoginCredentials();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        UserLoginGateway properties = new UserLoginGateway(credentialText.getText(), passwordText.getText(), this.database);
        UserLoginInteractor guard = new UserLoginInteractor(properties);
        guard.allowLogin();

    }
}
