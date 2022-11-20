package Screens;
import Entities.User;
import PresentersControllersGateways.UserLoginGateway;
import UseCases.UserRetriever;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class UserLoginUI implements ActionListener {

    private JTextField credentialText;
    private JLabel passwordLabel;
    private JPasswordField passwordText;

    private UserRetriever database;

    public UserLoginUI(UserRetriever database){
        this.database = database;
    }
    public void getLoginCredentials(){
        JFrame loginFrame = new JFrame();
        loginFrame.setSize(400, 400);
        loginFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel loginPanel = new JPanel();
        loginFrame.add(loginPanel);

        loginPanel.setLayout(null);
        JLabel credentialLabel = new JLabel("Enter username/email:");
        credentialLabel.setBounds(10,25, 200, 25);
        credentialText = new JTextField();
        credentialText.setBounds(210, 25, 100, 25);

        loginPanel.add(credentialLabel);
        loginPanel.add(credentialText);

        passwordLabel = new JLabel("Enter Password:");
        passwordLabel.setBounds(10,55, 200, 25);
        passwordText = new JPasswordField();
        passwordText.setBounds(210, 55, 100, 25);

        loginPanel.add(passwordLabel);
        loginPanel.add(passwordText);

        JButton loginButton = new JButton("login");
        loginButton.setBounds(210, 95, 100, 25);
        loginPanel.add(loginButton);
        loginButton.addActionListener(this);
        loginFrame.setVisible(true);

    }

    public static void main(String[] args){
        UserRetriever testDB = new UserDatabase(new File("Test5"));
        UserLoginUI screen = new UserLoginUI(testDB);
        screen.getLoginCredentials();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        UserLoginGateway properties = new UserLoginGateway(credentialText.getText(), passwordText.getText(), this.database);

    }
}
