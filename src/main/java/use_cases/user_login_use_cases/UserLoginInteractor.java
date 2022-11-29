package use_cases.user_login_use_cases;

import entities.user_entities.User;
import interface_adapters.User_search_IA.UserRetriever;
import interface_adapters.login_interface_adapters.UserLoginGateway;
import use_cases.user_login_use_cases.UserLoginInputBoundary;

import javax.swing.*;

public class UserLoginInteractor implements UserLoginInputBoundary {
    private final String credential;
    private final String password;
    private final UserRetriever database;

    public UserLoginInteractor(UserLoginGateway properties){
        this.credential = properties.getCredential();
        this.password = properties.getPassword();
        this.database = properties.getDatabase();
    }

    @Override
    public void allowLogin(){
        User user = database.getUser(this.credential);
        try{
            boolean allowLogin = user.PasswordMatch(this.password);
            if(allowLogin){
                user.login();
            }else{
                accessDenied("Wrong Password");
            }
        }catch(NullPointerException e){
            accessDenied("An account with this credential does not exist");
        }
    }

    public void accessDenied(String message){
        JFrame accessDenied = new JFrame();
        accessDenied.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        accessDenied.setSize(200, 400);
        JPanel accessDeniedPanel = new JPanel();
        accessDenied.add(accessDeniedPanel);
        JLabel messageLabel = new JLabel(message);
        messageLabel.setBounds(50, 200, 300, 25);
        accessDeniedPanel.add(messageLabel);
        accessDenied.setVisible(true);
    }


}
