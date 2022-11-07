/**
 * Provides the UI elements
 */
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class UserSearchUI {
    private JLabel label;

    public UserSearchUI() {
        final JFrame frame = new JFrame();
        frame.setSize(300, 100);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout());

        final JTextField field = new JTextField("Enter a username");

        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText(field.getText());
            }

        });
        frame.add(field);

        label = new JLabel();
        frame.add(label);
        frame.setVisible(true);
  }


    public static void main(String[] args) {
        new UserSearchUI();

    }
}






