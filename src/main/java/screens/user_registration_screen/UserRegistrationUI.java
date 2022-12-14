package screens.user_registration_screen;
import interface_adapters.user_registration_interface_adapters.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** This is screen on which the User enters his credentials in order to login**/
public class UserRegistrationUI implements ActionListener, userRegCredentialsRetriever {
    private final UserExistsPresenter verifyUser;
    private JTextField usernameText;
    private JTextField passwordText;
    private JTextField emailText;
    /*
    currently the below variable is not used, because only email verification is implemented, but it may be used in
    the future.
    */
    private JTextField deliveryText;

    public UserRegistrationUI(UserExistsPresenter existsInputBoundary) {
        this.verifyUser = existsInputBoundary;
    }
    /**
     * Creates the frame on which the user inputs account registration credentials
     * **/
    @Override
    public void getUserCredentials(){
        //Front end related objects
        JFrame registerFrame = new JFrame();
        registerFrame.setSize(400, 200);
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
        JLabel deliveryLabel = new JLabel("Choose verification Path(0 for email, 1 for phone):");
        deliveryLabel.setBounds(10, 115, 400, 25);

        deliveryText = new JTextField(20);
        deliveryText.setBounds(320, 115, 50, 25);
        registerPanel.add(deliveryLabel);
        registerPanel.add(deliveryText);

        //The Button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 140, 165, 25);
        registerButton.addActionListener(this);
        registerPanel.add(registerButton);
        registerFrame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String username = usernameText.getText();
        String password = passwordText.getText();
        String email = emailText.getText();

        // Makes sure that the credentials entered are of the correct format, may use regex to correct this
        if(username.equals("")|| password.equals("")|| email.equals("")){
            missingCredentials();
        }else{
            //currently only email verification is enabled.
            verifyUser.setCodeDeliveryMethod("Email");
            verifyUser.register(username, password, email);
        }
    }
    /**
     * The frame that shows up when the credentials entered are not of the right format
     * **/
    public void missingCredentials(){
        JFrame credentialsMissing = new JFrame();
        credentialsMissing.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        credentialsMissing.setSize(210, 100);
        JPanel CredentialsMissingPanel = new JPanel();
        CredentialsMissingPanel.setLayout(null);
        credentialsMissing.add(CredentialsMissingPanel);

        JLabel accountExists = new JLabel("Missing required information");
        accountExists.setBounds(10, 20, 350, 30);
        CredentialsMissingPanel.add(accountExists);
        credentialsMissing.setVisible(true);
    }
}
