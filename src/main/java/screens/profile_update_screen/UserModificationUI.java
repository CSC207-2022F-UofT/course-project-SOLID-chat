package screens.profile_update_screen; /**
 * Provides the UI elements
 */
import data_access.UserDatabase;
import entities.user_entities.User;
import interface_adapters.profile_modification_IA.ChangeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserModificationUI implements ChangeController {
    private JLabel label;
    public UserModificationUI() {
        final JFrame frame = new JFrame();
        frame.setSize(500, 300);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

//      Field for username
        final JTextField usernameField = new JTextField("Enter your current username");
        usernameField.setBounds(10, 25, 100, 25);

//      Field for password
        final JTextField passwordField = new JTextField("Enter your current password");
        passwordField.setBounds(10, 25, 100, 25);

//      to select feature that user wants to change
        JLabel lbl = new JLabel("<html>Select what feature<br>you wish to change</html>");
        lbl.setVisible(true);
        lbl.setBounds(10, 25, 100, 25);
        String[] choices = { "Username","Password", "Email"};
        final JComboBox<String> cb = new JComboBox<>(choices);

//      new value of the feature
        final JTextField newFeatureField = new JTextField("Enter the new value for this feature and click OK");
        newFeatureField.setBounds(10, 25, 100, 25);


//      OK button to process
        JButton btn = new JButton("OK");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = (usernameField.getText());
                String password = (passwordField.getText());
                String item = cb.getSelectedItem().toString();
                String newFeature = (newFeatureField.getText());
                boolean success = reportChange(username, password, item, newFeature);
                if (success){
                    label.setText("Your " + item + " was successfully changed.");
                }
                else{
                    label.setText("<html>Change was not successful.<br>Please make sure your username and " +
                            "<br>password match an existing account.</html>");
                }
            }
        });

        label = new JLabel();

        frame.add(usernameField);
        frame.add(passwordField);
        frame.add(cb);
        frame.add(lbl);
        frame.add(newFeatureField);
        frame.add(btn);
        frame.add(label);


        frame.setVisible(true);
    }

//      profile_modification_IA.ChangeController makes UI implement reportChange to invert the use-case --> UI dependency
    @Override
    public boolean reportChange(String username, String password, String feature, String newFeature) {
        UserDatabase db = new UserDatabase();
        if (db.UserExists(username)){
            User user = db.getUser(username);
            if (user.PasswordMatch(password) & user.getUsername().equals(username)){
                user.changeFeature(feature, newFeature);
                // this serializes the change
                db.modifyUser(username, user);
                return true;
            }
        }
        return false;
    }

// for trying out the code:
//    public static void main(String[] args) {
//        new profile_update_screen.UserModificationUI();
//
//    }

}
