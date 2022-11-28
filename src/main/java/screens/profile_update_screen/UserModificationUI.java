package screens.profile_update_screen;
import interface_adapters.profile_modification_IA.ChangeControllerClass;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;


/**
 * Provides the UI elements.
 */
public class UserModificationUI {
    ChangeControllerClass c = new ChangeControllerClass();
    private final JLabel label;
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
                String item = Objects.requireNonNull(cb.getSelectedItem()).toString();
                String newFeature = (newFeatureField.getText());
                boolean success = c.reportChange(username, password, item, newFeature);
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

        frame.setTitle("Profile Editor Tool");
        frame.add(usernameField);
        frame.add(passwordField);
        frame.add(cb);
        frame.add(lbl);
        frame.add(newFeatureField);
        frame.add(btn);
        frame.add(label);


        frame.setVisible(true);
    }

}
