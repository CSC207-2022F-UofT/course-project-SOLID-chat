package UI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UserRegistrationUI implements ActionListener {
    private final UserDatabase database;
    private JLabel registrationSuccess;
    private JTextField usernameText;
    private JTextField passwordText;
    private JTextField emailText;
    private JButton register;

    private final int code;

    public UserRegistrationUI(UserDatabase database) {
        this.database = database;
        /*TODO: For now the code is 389 for testing purposes, but once UI.UserVerificationUI.sendVerificationCode() is
            implemented this will be a random integer.
        */
        /*code = new Random().nextInt(1244254);*/
        code = 389;
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
    /*@Override*/
    /*public void registerUser(String username, String password, String email) {
        if(database.UserExists(username, email)){
            registrationSuccess.setText("The username or password is already in use, please try again");
        }else{
            registrationSuccess.setText("Please verify to create your account");
            UserVerificationUI verifyUser = new UserVerificationUI(code, email);
            if(verifyUser.verify(email)){
                database.createUser(username, password, email, "Basic");
                registrationSuccess.setText("Your account is now created");
            }else{
                registrationSuccess.setText("You could not be verified, please try again");
            };
        }
    }*/
    //For Testing purposes
    public static void main(String[] args){
        UserDatabase testDB = new UserDatabase(new File("Test5"));
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
        UserRegistrationController verifyUser = new UserRegistrationController(code, username, password, email, database);
        verifyUser.registerUser();
    }
}
