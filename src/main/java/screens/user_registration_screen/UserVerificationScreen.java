package screens.user_registration_screen;
import interface_adapters.user_registration_interface_adapters.UserExistsOutputView;
import interface_adapters.user_registration_interface_adapters.UserVerificationPresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * This is the class that is responsible for retrieving the verification code form the user, or presenting if
 * verification is not possible
 * */
public class UserVerificationScreen implements UserExistsOutputView, ActionListener {
    private final JTextField verText = new JTextField(20);
    private final UserVerificationPresenter verificationInputBoundary;
    private int code;
    private String username;
    private String password;
    private String email;

    public UserVerificationScreen(UserVerificationPresenter verificationInputBoundary){
        this.verificationInputBoundary = verificationInputBoundary;
    }
    /**
     * This method asks for the code from the user
     * */
    @Override
    public void getVerificationCredentials() {
        ViewHelper.simpleTextEntryFrame("Enter the verification code:", this, 200, verText);
    }
    /**
     * This method presents that verification is not possible, because the user exists in the database
     * */
    @Override
    public void presentUserExistsMessage() {
        ViewHelper.simpleMessage("A user with this email or username already exists", 350);
    }
    /**
     * Retrieves code from the input boundary, to set the code onto the other input boundary in the constructor
     * @param code verification code
     * */
    @Override
    public void getCode(int code) {
        this.code = code;
    }

    /**
     * Retrieves user credentials from the input boundary, in order to set the credentials onto the other input
     * boundary in the constructor
     * */
    @Override
    public void getUserCredentials(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Need if statements to check if code is an integer
        int code = Integer.parseInt(verText.getText());
        verificationInputBoundary.setCode(this.code);
        verificationInputBoundary.setCredentials(username, password, email);
        verificationInputBoundary.verify(code);
    }

}
