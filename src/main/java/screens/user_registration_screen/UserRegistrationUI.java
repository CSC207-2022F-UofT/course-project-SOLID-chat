package screens.user_registration_screen;
import data_access.Database;
import data_access.UserDatabase;
import use_cases.user_registration_use_cases.UserExistsInputBoundary;
import use_cases.user_registration_use_cases.UserExistsInteractor;
import use_cases.user_registration_use_cases.userRegCredentialsRetriever;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/** This is screen on which the User enters his credentials in order to login**/
public class UserRegistrationUI implements ActionListener, userRegCredentialsRetriever {
    private final UserExistsInputBoundary verifyUser;
    private JTextField usernameText;
    private JTextField passwordText;
    private JTextField emailText;

    private JTextField deliveryText;

    public UserRegistrationUI(UserExistsInputBoundary verifyUser) {
        this.verifyUser = verifyUser;
    }
    @Override
    public void getUserCredentials(){
        //Front end related objects
        JFrame registerFrame = new JFrame();
        registerFrame.setSize(500, 300);
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel registerPanel = new JPanel();
        registerFrame.add(registerPanel);

        //The textbox for entering the Username
        registerPanel.setLayout(null);
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 25, 100, 25);
        registerPanel.add(usernameLabel);

        usernameText = new JTextField(20);
        usernameText.setBounds(100, 20, 165, 25);
        registerPanel.add(usernameText);

        //The textbox for entering the password
        JLabel passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 55, 100, 25);
        registerPanel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        registerPanel.add(passwordText);

        //The textbox for entering the email
        JLabel emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 85, 100, 25);
        registerPanel.add(emailLabel);

        emailText = new JTextField(20);
        emailText.setBounds(100, 80, 165, 25);
        registerPanel.add(emailText);

        //The textbox for entering verification path
        JLabel deliveryLabel = new JLabel("Choose verification Path(0 for email, 1 for phone)");
        deliveryLabel.setBounds(10, 115, 200, 25);

        deliveryText = new JTextField(20);
        deliveryText.setBounds(100, 110, 50, 25);
        registerPanel.add(deliveryLabel);
        registerPanel.add(deliveryText);

        //The Button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 140, 165, 25);
        registerButton.addActionListener(this);
        registerPanel.add(registerButton);
        registerFrame.setVisible(true);
    }

    public static void main(String[] args){
        Database testDB = new UserDatabase(new File("test20123"));
        UserExistsInputBoundary interactor = new UserExistsInteractor(testDB);
        new UserRegistrationUI(interactor).getUserCredentials();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //Need if statements for cases
        String username = usernameText.getText();
        String password = passwordText.getText();
        String email = emailText.getText();
        String type = deliveryText.getText();

        verifyUser.setCodeDeliveryMethod(type);
        verifyUser.register(username, password, email);
    }
}
