package Interface_adapters.login_interface_adapters;

import entities.user_entities.User;
import Interface_adapters.User_search_IA.UserRetriever;

import javax.swing.*;

public class UserLoginController {
    private final String credential;
    private final String password;
    private final UserRetriever database;

    public UserLoginController(UserLoginGateway properties){
        this.credential = properties.getCredential();
        this.password = properties.getPassword();
        this.database = properties.getDatabase();
    }

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
