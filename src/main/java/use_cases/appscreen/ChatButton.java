package use_cases.appscreen;

import entities.chat.CommonPrivatechat;
import entities.chat.PrivateChatfactory;
import screens.chat_screen.ChatController;
import screens.chat_screen.ChatView;
import use_cases.chat_initiation_use_case.ChatInputBoundry;
import use_cases.chat_initiation_use_case.ChatInteractor;

import javax.swing.*;
import java.awt.*;
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
        jButton.addActionListener(e -> {
            PrivateChatfactory privateChatfactory = new CommonPrivatechat();
            ChatInputBoundry inputBoundary = new ChatInteractor(privateChatfactory);
            ChatController controller = new ChatController(inputBoundary, currentUsername);
            new ChatView(controller, false);
        });
        return jButton;
    }

    public static void main(String[] args) {
        JButton jButton = ChatButton.createButton("sender username", "amy", LocalDateTime.now());
        JFrame jFrame = new JFrame();
        jFrame.setSize(300,500);
        jFrame.add(jButton);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
}
