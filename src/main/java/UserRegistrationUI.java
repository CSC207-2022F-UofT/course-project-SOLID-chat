import junit.framework.JUnit4TestAdapter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UserRegistrationUI implements UserRegistrationUseCase, ActionListener {
    private UserDatabase database;

    //Front end related objects
    private JFrame RegisterFrame;
    private JPanel RegisterPanel;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JLabel emailLabel;
    private JTextField usernameText;
    private JTextField passwordText;
    private JTextField emailText;
    private JButton register;

    public UserRegistrationUI(UserDatabase database) {
        this.database = database;
    }
    void GetUserCredentials(){
        RegisterFrame = new JFrame();
        RegisterFrame.setSize(300, 300);
        RegisterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RegisterPanel = new JPanel();
        RegisterFrame.add(RegisterPanel);

        //The textbox for entering the Username
        RegisterPanel.setLayout(null);
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 25, 100, 25);
        RegisterPanel.add(usernameLabel);

        usernameText = new JTextField(20);
        usernameText.setBounds(100, 20, 165, 25);
        RegisterPanel.add(usernameText);

        //The textbox for entering the password
        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 55, 100, 25);
        RegisterPanel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        RegisterPanel.add(passwordText);

        //The textbox for entering the email
        emailLabel = new JLabel("Email");
        emailLabel.setBounds(10, 85, 100, 25);
        RegisterPanel.add(emailLabel);

        emailText = new JTextField(20);
        emailText.setBounds(100, 80, 165, 25);
        RegisterPanel.add(emailText);

        //The Button
        register = new JButton("Register");
        register.setBounds(100, 110, 165, 25);
        RegisterPanel.add(register);



        RegisterFrame.setVisible(true);
    }
    @Override
    public void registerUser(String username, String password, String email) {
        if(database.UserExists(username, email)){
            System.out.println("The username or password is already in use, please try again");
        }else{
            database.createUser(username, password, email, "Basic");
            System.out.println("Your account has been created, please verify to login");
            UserVerificationUI verifyUser = new UserVerificationUI(389);
            verifyUser.verify(email);
        }
    }

    public static void main(String[] args){
        UserDatabase testDB = new UserDatabase();
        UserRegistrationUI testUI = new UserRegistrationUI(testDB);
        testUI.GetUserCredentials();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameText.getText();
        String password = passwordText.getText();
        String email = emailText.getText();
        this.registerUser(username, password, email);

    }
}
