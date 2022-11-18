package UI;

import Controllers.UserRegistrationUseCase;
import UseCase.UserVerifier;
import UseCase.verificationMethodFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class UserRegistrationController implements UserVerifier, ActionListener, UserRegistrationUseCase {
    private final String username;
    private final String password;
    private final String email;
    private UserDatabase database;
    Random random;
    private final int code;
    private JTextField verificationCodeText;
    private JLabel success;

    public UserRegistrationController(int code, String Username, String Password, String email, UserDatabase database){
        this.code = code;
        this.username = Username;
        this.password = Password;
        this.email = email;
        this.database = database;
    }

    //Asks for the verification code from the user, and matches it with this.code to potentially verify the user
    public void verify(String email){
        JFrame verificationFrame = new JFrame();
        verificationFrame.setSize(400, 200);
        verificationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        if(database.UserExists(this.username, this.email)){
            System.out.println("A user with this username or email already exists");
        }else{
            this.verify(email);
        }
    }

    //For testing purposes
    /*public static void main(String[] args){
        UI.UserVerificationUI ver = new UI.UserVerificationUI(389);
        ver.verify("abc");
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        int verCode = Integer.parseInt(verificationCodeText.getText());
        if(verCode == this.code){
            database.createUser(this.username, this.password, this.email, "Basic");
            System.out.println("Verification successful");
        }else{
            System.out.println("Could not verify please try again");
        }
    }
}
