package interface_adapters.user_registration_interface_adapters;

import use_cases.user_login_use_case.UserCreator;
import interface_adapters.user_registration_interface_adapters.UserVerifier;
import use_cases.user_login_use_case.verificationMethodFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class UserRegistrationController implements UserVerifier, ActionListener, UserRegistrator {
    private final String username;
    private final String password;
    private final String email;
    private String preference;
    private boolean userExists = false;
    private UserCreator database;
    Random random;
    private final int code;
    private JTextField verificationCodeText;
    private JLabel success;

    /*public UserRegistrationController(int code, String Username, String Password, String email, UserDatabase database){
        this.code = code;
        this.username = Username;
        this.password = Password;
        this.email = email;
        this.database = database;
    }*/

    public UserRegistrationController(UserRegistrationGateway properties){
        this.username = properties.getUsername();
        this.password = properties.getPassword();
        this.email = properties.getEmail();
        this.userExists = properties.isUserExists();
        this.code = properties.getCode();
        this.database = properties.getDatabase();
    }

    //Asks for the verification code from the user, and matches it with this.code to potentially verify the user
    public void verify(String email){
        JFrame verificationFrame = new JFrame();
        verificationFrame.setSize(400, 200);
        verificationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel verificationPanel = new JPanel();
        verificationFrame.add(verificationPanel);

        verificationPanel.setLayout(null);
        JLabel verificationLabel = new JLabel("Verification Code");
        verificationLabel.setBounds(10,25, 200, 25);
        verificationCodeText = new JTextField();
        verificationCodeText.setBounds(125, 20, 165, 25);

        verificationPanel.add(verificationLabel);
        verificationPanel.add(verificationCodeText);

        //Success/Failure Labels
        success = new JLabel("");
        success.setBounds(10, 50, 100, 25);
        verificationPanel.add(success);

        JButton verifyButton = new JButton("verify");
        verifyButton.setBounds(125, 50, 100, 25);
        verificationPanel.add(verifyButton);
        verifyButton.addActionListener(this);
        verificationFrame.setVisible(true);

        verificationMethodFactory mailMan = new verificationMethodFactory(email, "Email", code);
        mailMan.deliverCode();
    }

    public void registerUser() {
        if(this.userExists){
            System.out.println("An account with this username or email already exists");
            accountExistsMessage();
        }else{
            this.verify(email);
        }
    }

    public static void accountExistsMessage(){
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

    public static void verificationSuccessMessage(){
        JFrame verificationSuccessFrame = new JFrame();
        verificationSuccessFrame.setSize(400, 100);
        verificationSuccessFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel verificationSuccessPanel = new JPanel();
        verificationSuccessPanel.setLayout(null);
        verificationSuccessFrame.add(verificationSuccessPanel);
        JLabel errorMessage = new JLabel("Could not verify please try again");
        errorMessage.setBounds(10,20, 350, 20);
        verificationSuccessPanel.add(errorMessage);
        verificationSuccessFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int verCode = Integer.parseInt(verificationCodeText.getText());
        if(verCode == this.code){
            database.createUser(this.username, this.password, this.email, "Basic");
            System.out.println("Verification successful");
        }else{
            verificationSuccessMessage();
        }
    }
}
