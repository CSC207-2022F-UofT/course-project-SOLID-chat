package screens.user_registration_screen;
import screens.login_screen.UserLoginMain;

import javax.swing.*;

/** This is the screen in which the user chooses to either register or login. **/
public class LoginRegisterScreen {
    JButton login = new JButton("login");
    JButton register = new JButton("register");

    public LoginRegisterScreen(){
        JFrame loginRegFrame = new JFrame();
        loginRegFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loginRegFrame.setSize(400, 200);
        JPanel loginRegPanel = new JPanel();
        loginRegFrame.add(loginRegPanel);
        JLabel message = new JLabel("Do you want to Login or Register?");
        message.setBounds(10, 30, 200, 25);
        loginRegPanel.add(message);
        login.setBounds(10, 60, 70, 30);
        login.addActionListener(new UserLoginMain());
        register.setBounds(110, 60, 70, 30);
        register.addActionListener(new UserRegistrationMain());
        loginRegPanel.add(login);
        loginRegPanel.add(register);
        loginRegFrame.setVisible(true);

    }
    public static void main(String[] args){
        new LoginRegisterScreen();
    }
}
