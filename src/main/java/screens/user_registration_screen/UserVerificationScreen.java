package screens.user_registration_screen;

import use_cases.user_registration_use_cases.UserExistsOutputBoundary;
import use_cases.user_registration_use_cases.UserVerificationInputBoundary;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserVerificationScreen implements UserExistsOutputBoundary, ActionListener {
    private final JTextField verText = new JTextField(20);
    private final UserVerificationInputBoundary verificationInputBoundary;

    public UserVerificationScreen(UserVerificationInputBoundary verificationInputBoundary) {
        this.verificationInputBoundary = verificationInputBoundary;
    }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        // Need if statements to check if code is an integer
        int code = Integer.parseInt(verText.getText());
        verificationInputBoundary.verify("Email", code);
    }

}
