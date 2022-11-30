package screens.user_registration_screen;

import data_access.UserDatabase;
import screens.login_screen.UserLoginUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** This is the screen in which the user chooses to either register or login. **/
public class LoginRegisterScreen implements ActionListener {

    private final UserRegistrationUI registrationUI;
    private final UserLoginUI loginUI;
    JButton login = new JButton("login");
    JButton register = new JButton("register");

    public LoginRegisterScreen(UserRegistrationUI registrationUI, UserLoginUI loginUI){
        this.registrationUI = registrationUI;
        this.loginUI = loginUI;
        JFrame loginRegFrame = new JFrame();
        loginRegFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginRegFrame.setSize(400, 200);
        JPanel loginRegPanel = new JPanel();
        loginRegFrame.add(loginRegPanel);
        JLabel message = new JLabel("Do you want to Login or Register?");
        message.setBounds(10, 30, 200, 25);
        loginRegPanel.add(message);
        login.setBounds(10, 60, 70, 30);
        login.addActionListener(this);
        register.setBounds(110, 60, 70, 30);
        register.addActionListener(this);
        loginRegPanel.add(login);
        loginRegPanel.add(register);
        loginRegFrame.setVisible(true);

    }
    /*public static void main(String[] args){
        LoginRegisterScreen screen = new LoginRegisterScreen();
    }*/
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(login)){
            loginUI.getLoginCredentials();
        }else{
            registrationUI.getUserCredentials();
        }
    }
}