package screens.user_registration_screen;

import interface_adapters.user_registration_interface_adapters.UserRegistrationController;
import interface_adapters.user_registration_interface_adapters.UserRegistrationGateway;
import data_access.UserDatabase;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;

public class UserRegistrationUI implements ActionListener {
    private final UserDatabase database;
    private JLabel registrationSuccess;
    private JTextField usernameText;
    private JTextField passwordText;
    private JTextField emailText;
    private JButton register;
    private static JButton phoneVerify = new JButton("Phone");
    private static JButton emailVerify = new JButton("Email");
    private final int code;

    public UserRegistrationUI(UserDatabase database) {
        this.database = database;
        /*TODO: For now the code is 389 for testing purposes, but once UI.UserVerificationUI.sendVerificationCode() is
            implemented this will be a random integer.
        */
        code = new Random().nextInt(1244254);
    }
    void GetUserCredentials(){
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

        //The Button
        register = new JButton("Register");
        register.setBounds(100, 110, 165, 25);
        register.addActionListener(this);
        registerPanel.add(register);

        //Success/Failure Label
        registrationSuccess = new JLabel("");
        registrationSuccess.setBounds(10, 140, 350, 25);
        registerPanel.add(registrationSuccess);

        registerFrame.setVisible(true);
    }

    public void getPreferredDeliveryMethod(){
        JFrame preference = new JFrame();
        preference.setSize(400, 200);
        JPanel preferancePanel = new JPanel();
        preference.add(preferancePanel);

        JLabel message = new JLabel("Send verification code via:");
        message.setBounds(30, 120, 300, 20);
        preferancePanel.add(message);

        emailVerify.setBounds(30, 150, 140, 25);
        emailVerify.addActionListener(this);
        phoneVerify.setBounds(150, 150, 140, 25);
        phoneVerify.addActionListener(this);
        preferancePanel.add(emailVerify);
        preferancePanel.add(phoneVerify);
        preference.setVisible(true);

    }

    public static void main(String[] args){
        UserDatabase testDB = new UserDatabase(new File("Test8"));
        System.out.println(testDB.UserExists("RandomUser", "abdfeg@gmail.com"));
        System.out.println(testDB.getList().size());
        UserRegistrationUI testUI = new UserRegistrationUI(testDB);

        testUI.GetUserCredentials();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameText.getText();
        String password = passwordText.getText();
        String email = emailText.getText();

        UserRegistrationGateway properties = new UserRegistrationGateway();
        properties.setUsername(username);
        properties.setPassword(password);
        properties.setEmail(email);
        properties.setUserExists(database.UserExists(username, email));
        properties.setCode(code);
        properties.setDatabase(this.database);
        getPreferredDeliveryMethod();
        //Not an error below, we just have not implemented sending code via phone yet.
        if(e.getSource() == emailVerify || e.getSource() == phoneVerify){
            properties.setPreference("Email");
            UserRegistrationController verifyUser = new UserRegistrationController(properties);
            verifyUser.registerUser();
        }
    }
}
