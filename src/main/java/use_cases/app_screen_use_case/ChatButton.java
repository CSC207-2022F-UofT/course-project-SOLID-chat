package use_cases.app_screen_use_case;

import screens.chat_screen.ChatView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class ChatButton {


    /**
     * Create and return a button for an existing chat object
     * @param chatName The name of the chat
     * @param currentUsername The username of the current user
     * @param lastUpdated The time of the last update to a chat's conversation history
     * @return The button created
     */
    public static JButton createButton(String chatName, String currentUsername, LocalDateTime lastUpdated){
        JButton jButton = new JButton(chatName);
        jButton.setPreferredSize(new Dimension(280, 50));

        JLabel jLabel;
        if (lastUpdated != null){
            jLabel = new JLabel(String.valueOf(lastUpdated.toLocalDate()));
        }
        else{
            jLabel = new JLabel();
        }
        jLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
        jLabel.setFont(new Font(null, Font.BOLD, 11));
        jButton.add(jLabel);

        // defines the action of opening a chat when a chat is clicked on
        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        return jButton;
    }
}
