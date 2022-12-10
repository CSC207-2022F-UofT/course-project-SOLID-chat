package screens.login_screen;

import interface_adapters.login_interface_adapters.ForgotPasswordPresenter;
import screens.user_registration_screen.ViewHelper;

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
        ViewHelper.simpleTextEntryFrame("Enter the verification code, sent to your email:",
                this, 300, verText);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int code = Integer.parseInt(verText.getText());
        forgotPasswordPresenter.allowLogin(code);
    }
}
