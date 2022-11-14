/**
 * Provides the UI elements
 */
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class UserSearchUI implements UserPresenter{
    private JLabel label;

//    setting up access to the database of users:
    UserDatabase db = UserDatabase(accounts);


    public UserSearchUI() {
        final JFrame frame = new JFrame();
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());

        final JTextField field = new JTextField("Enter a username");

        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(showProfile(field.getText()));
            }

        });
        frame.add(field);
        label = new JLabel();
        frame.add(label);
        frame.setVisible(true);
  }

//  UserPresenter makes UI implement showProfile to invert the use-case --> UI dependency
    @Override
    public String showProfile(String username) {
        if (db.UserExists(username)){
            UserReader reader = new UserReader();
            String[] features = reader.UserReader(username);
            String email = features[1];
            return("<html>Username: " + username + "<br>Email: " + email + "</html>");
        }
        else{
            return("User with given username does not exist.");
        }
    }

// for trying out the code:
//    public static void main(String[] args) {
//        new UserSearchUI();
//
//    }

}






