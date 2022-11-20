package screens.app_screen;


import use_cases.app_screen_use_case.AppScreenController;
import use_cases.app_screen_use_case.AppScreenPresenter;
import use_cases.app_screen_use_case.ChatName;
import use_cases.app_screen_use_case.Refresh;
import entities.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AppScreen implements AppScreenPresenter, AppScreenController, ChatName, Refresh {

    private final JFrame jFrame;
    private JScrollPane jScrollPane;
    private final String currentUsername;
    private ArrayList<Chat> chats;


    /**
     Create an AppScreen object
     @param chats This is a list of chats given by the user (the list will always come as sorted with the
     most recent chats at the end of the list)
     */
    public AppScreen(String currentUsername, ArrayList<Chat> chats) {
        this.currentUsername = currentUsername;
        this.chats = chats;
        jFrame = new JFrame();
        jFrame.setSize(300, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // top panel containing the buttons for creating a new chat
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,2));

        JButton addPrivateChat = new JButton("+ Private Chat");
        JButton addGroupChat = new JButton("+ Group Chat");

        addPrivateChat.setPreferredSize(new Dimension(40, 30));
        addGroupChat.setPreferredSize(new Dimension(40, 30));

        // adding the action listeners for the +private-chat and +group-chat buttons
        addPrivateChat.addActionListener(e -> {
            ChatView newChat = new ChatView(currentUsername, true, "");
            newChat.chatDisplay();

        });
        //TODO: add groupchat action
//        addGroupChat.addActionListener(e -> {
//            ChatView newChat = new ChatView(currentUsername, true);
//            newChat.chatDisplay();
//        });


        topPanel.add(addPrivateChat);
        topPanel.add(addGroupChat);
        jFrame.add(topPanel, BorderLayout.NORTH);

        this.chats = chats;
        openScreen();

    }

    /**
     * Attempts to open the screen to display to the user
     */
    @Override
    public void openScreen() {
        try{
            displayAppScreen();
        } catch (Exception e) {
            throw new RuntimeException("Unable to to open screen");
        }

    }

    /**
     Display a screen containing an ordered list of chats to the user based on latest conversation times
     */
    public void displayAppScreen(){

        JPanel jPanel = new JPanel();

        // getting the names of each chat to display and creating buttons for each chat
        for (int i = this.chats.size() - 1; i > -1; i--) {

            String chatName = getChatName(this.chats.get(i));
            JButton b = new JButton(chatName);
            b.setPreferredSize(new Dimension(280, 50));
            JLabel jLabel = new JLabel("time");
            jLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
            jLabel.setFont(new Font(null, Font.BOLD, 11));
            b.add(jLabel);

            // defines the action of opening a chat when a chat is clicked on
            b.addActionListener(e -> {

                ChatView newChat = new ChatView(currentUsername, false, chatName);
                newChat.chatDisplay();
            });
            jPanel.add(b);
        }

        jPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        // set height of panel to appropriate size based on the number of chats
        jPanel.setPreferredSize(new Dimension(100, 60 * this.chats.size()));
        jPanel.setBorder(BorderFactory.createTitledBorder("My Chats"));


        // making the chat list scrollable
        scrollableChats(jPanel);

        jFrame.setVisible(true);

    }

    /**
     Make the chat list scrollable
     @param jPanel The panel containing the chats
     */
    private void scrollableChats(JPanel jPanel) {
        JScrollPane scrollFrame = new JScrollPane(jPanel);
        jScrollPane = scrollFrame;
        scrollFrame.setPreferredSize(new Dimension( 200,500));
        scrollFrame. getVerticalScrollBar().setUnitIncrement(5);
        jFrame.getContentPane().add(scrollFrame);
    }


    /**
     * Get the name of the chat
     * @param chat The chat in context
     * @return name
     */
    @Override
    public String getChatName(Chat chat) {
        return chat.getName();
    }

    /**
     * Update the order of the chats
     * @param chat The chat that has an update
     */
    public void updateChatOrder(Chat chat){

        if (this.chats.contains(chat)) {
            this.chats.remove(chat);
            this.chats.add(chat);
        }
        else {
            this.chats.add(chat);
        }

    }

    /**
     * Add a new chat to the screen, if the chat already exists (i.e. there exists a chat with the
     * same ID, do nothing)
     * @param chat The new chat to be added
     */
    public void addNewChat(Chat chat){

        if (!(this.chats.contains(chat))){
            updateChatOrder(chat);
            jFrame.remove(this.jScrollPane);

            // refresh the screen
            displayAppScreen();

        }
    }

    /**
     * Update the order of chats that appear on screen if there was a change to conversation history
     * @param chatID The ID of the given chat
     */
    @Override
    public void updateScreen(String chatID) {
        if (hasUpdate(chatID)){

            updateChatOrder(getChat(chatID));
            jFrame.remove(this.jScrollPane);

            // refresh the screen
            displayAppScreen();
        }
    }

    /**
     * Return true if the given chat as an update to its conversation history
     * @param chatID The ID of the given chat
     * @return true/false
     */
    @Override
    public boolean hasUpdate(String chatID) {
        Chat chat = getChat(chatID);
        return this.chats.get(this.chats.size() - 1) != chat;
    }

    /**
     * Get the chat object given its chat ID
     * @param chatID The ID of the chat
     * @return The chat with the given ID
     */
    @Override
    public Chat getChat(String chatID) {
        for (Chat chat: this.chats){
            if (chat.getChatID().equals(chatID)){
                return chat;
            }
        }
        throw new RuntimeException("Current user is not part of this chat");
    }

}
