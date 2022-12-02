package screens.user_registration_screen;
import use_cases.user_registration_use_cases.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * This is the class that is responsible for retrieving the verification code form the user, or presenting if
 * verification is not possible
 * */
public class UserVerificationScreen implements UserExistsOutputBoundary, ActionListener {
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
        JFrame verificationFrame = new JFrame();
        verificationFrame.setSize(250, 200);
        verificationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel verificationPanel = new JPanel();
        verificationPanel.setLayout(null);
        verificationFrame.add(verificationPanel);

        JLabel verificationLabel = new JLabel("Enter the verification code:");
        verificationLabel.setBounds(20, 30, 200, 25);
        verificationPanel.add(verificationLabel);

        verText.setBounds(10, 60, 200, 25);
        verificationPanel.add(verText);

        JButton verifyButton = new JButton("verify");
        verifyButton.addActionListener(this);
        verifyButton.setBounds(50, 90, 150, 30);
        verificationPanel.add(verifyButton);
        verificationFrame.setVisible(true);
    }
    /**
     * This method presents that verification is not possible, because the user exists in the database
     * */
    @Override
    public void presentUserExistsMessage() {
        JFrame userExistsFrame = new JFrame();
        userExistsFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        userExistsFrame.setSize(400, 100);
        JPanel userExistsPanel = new JPanel();
        userExistsPanel.setLayout(null);
        userExistsFrame.add(userExistsPanel);

        JLabel accountExists = new JLabel("A user with this email or username already exists");
        accountExists.setBounds(10, 25, 350, 30);
        userExistsPanel.add(accountExists);
        userExistsFrame.setVisible(true);
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
