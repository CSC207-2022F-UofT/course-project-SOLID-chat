package use_cases.user_registration_use_cases;

import data_access.Database;
import interface_adapters.user_registration_interface_adapters.UserRegistrationGateway;
import interface_adapters.user_registration_interface_adapters.UserRegistrationPresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class UserRegistrationInteractor implements UserVerifier, ActionListener, UserRegistrationInputBoundary {
    private final String username;
    private final String password;
    private final String email;
    private String preference;
    private boolean userExists = false;
    private final Database database;
    private final int code;
    private JTextField verificationCodeText;

    private final userRegistrationOutputBoundary output = new UserRegistrationPresenter();

    public UserRegistrationInteractor(UserRegistrationGateway properties){
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
        JLabel success = new JLabel("");
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
    @Override
    public void registerUser() {
        if(this.userExists){
            System.out.println("An account with this username or email already exists");
            output.accountExistsMessage();
        }else{
            this.verify(email);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        int verCode = Integer.parseInt(verificationCodeText.getText());
        if(verCode == this.code){
            database.createUser(this.username, this.password, this.email, "Basic");
            output.verificationSuccessMessage("Verification successful");
            output.registrationSuccessAction(this.database);
        }else{
            output.verificationSuccessMessage("verification unsuccessful");
        }
    }
}
