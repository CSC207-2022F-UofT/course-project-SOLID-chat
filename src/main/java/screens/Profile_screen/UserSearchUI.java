package screens.Profile_screen;
import interface_adapters.User_search_IA.UserPresenterClass;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Provides the UI elements
 */
public class UserSearchUI {
    private final JLabel label;
    private final UserPresenterClass p = new UserPresenterClass();

    public UserSearchUI() {
        final JFrame frame = new JFrame();
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        final JTextField field = new JTextField("Enter a username");

        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(p.showProfile(field.getText()));
            }

        });
        frame.setTitle("User Search Tool");
        frame.add(field);
        label = new JLabel();
        frame.add(label);
        frame.setVisible(true);
  }

}






