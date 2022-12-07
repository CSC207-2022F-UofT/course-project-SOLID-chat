package screens.login_screen;

import interface_adapters.login_interface_adapters.ForgotPasswordPresenter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgotPasswordScreen implements ActionListener {
    private final ForgotPasswordPresenter forgotPasswordPresenter;
    private final JTextField verText = new JTextField();

    public ForgotPasswordScreen(ForgotPasswordPresenter forgotPasswordPresenter){
        this.forgotPasswordPresenter = forgotPasswordPresenter;
    }

    public void getEntryCode(){
        //TODO: this is a code smell, as this is copypasta programming(method copied from UserVerificationScreen)
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
    public void actionPerformed(ActionEvent e) {
        int code = Integer.parseInt(verText.getText());
        forgotPasswordPresenter.allowLogin(code);
    }
}
