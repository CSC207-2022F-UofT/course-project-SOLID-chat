package screens.user_registration_screen;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * This class contains helper methods that help with preparing views in other classes
 * */
public class ViewHelper {
    /**
     * This method opens a frame displaying  a simple message
     * */
    public static void simpleMessage(String message, int n){
        JFrame newFrame = new JFrame();
        newFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        newFrame.setSize(n + 50, 100);
        JPanel newPanel = new JPanel();
        newPanel.setLayout(null);
        newFrame.add(newPanel);

        JLabel accountExists = new JLabel(message);
        accountExists.setBounds(10, 25, n, 30);
        newPanel.add(accountExists);
        newFrame.setVisible(true);
    }

    public static void simpleTextEntryFrame(String message, ActionListener listener, int n, JTextField verText){
        JFrame verificationFrame = new JFrame();
        verificationFrame.setSize(n + 50, 200);
        verificationFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel verificationPanel = new JPanel();
        verificationPanel.setLayout(null);
        verificationFrame.add(verificationPanel);

        JLabel verificationLabel = new JLabel(message);
        verificationLabel.setBounds(20, 30, n, 25);
        verificationPanel.add(verificationLabel);

        verText.setBounds(10, 60, 200, 25);
        verificationPanel.add(verText);

        JButton verifyButton = new JButton("verify");
        verifyButton.addActionListener(listener);
        verifyButton.setBounds(50, 90, 150, 30);
        verificationPanel.add(verifyButton);
        verificationFrame.setVisible(true);
    }
}
