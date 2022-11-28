import screens.Profile_screen.UserSearchUI;
import screens.profile_update_screen.UserModificationUI;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;


/**
 * Provides the main appl UI.
 */
public class Main {
    public static void  main(String[] args) {
        final JFrame f = new JFrame();
        f.setSize(400, 200);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setLayout(new FlowLayout());

        // to select feature that user wants to change
        JLabel lbl = new JLabel("<html>Select what you would like to do:</html>");
        lbl.setVisible(true);
        lbl.setBounds(10, 25, 100, 25);
        String[] choices = {"Search for users", "Modify my profile"};
        final JComboBox<String> cb = new JComboBox<>(choices);


        JButton btn = new JButton("OK");

        btn.addActionListener(e -> {
            String feature = Objects.requireNonNull(cb.getSelectedItem()).toString();
            switch (feature) {
                case "Search for users":
                    new UserSearchUI();
                    break;
                case "Modify my profile":
                    new UserModificationUI();
                    break;
            }
        });

        f.setTitle("SOLID Chat main menu");
        f.add(lbl);
        f.add(cb);
        f.add(btn);
        f.setVisible(true);

    }
    }

