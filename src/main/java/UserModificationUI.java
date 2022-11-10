/**
 * Provides the UI elements
 */
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserModificationUI implements ChangeController{
    private JLabel label;
    UserDatabase db = UserDatabase(accounts);
    public UserModificationUI() {
        final JFrame frame = new JFrame();
        frame.setSize(1200, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());

        final JTextField usernameField = new JTextField("Enter your current username");
        String username = (usernameField.getText());

        final JTextField passwordField = new JTextField("Enter your current password");
        String password = (passwordField.getText());

        JLabel lbl = new JLabel("<html>Select what feature<br>you wish to change</html>");
        lbl.setVisible(true);
        String[] choices = { "Username","Password", "Email"};
        final JComboBox<String> cb = new JComboBox<String>(choices);

        final JTextField newFeatureField = new JTextField("Enter the new value for this feature and click OK");
        String newFeature = (newFeatureField.getText());


        JButton btn = new JButton("OK");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = cb.getSelectedItem().toString();
                String newFeature = (passwordField.getText());
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

//      ChangeController makes UI implement reportChange to invert the use-case --> UI dependency
    @Override
//    TODO: fix based on new UserDatabase/ getUser features
    public boolean reportChange(String username, String password, String feature, String newFeature) {
        User user = db.getUser(username);
        if (user.getPassword().equals(password) && user.getUsername().equals(username)){
            user.changeFeature(feature, newFeature);
            return true;
        }
        return false;
    }

// for trying out the code:
//    public static void main(String[] args) {
//        new UserModificationUI();
//
//    }

}
