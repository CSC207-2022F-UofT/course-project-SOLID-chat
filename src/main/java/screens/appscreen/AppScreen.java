package screens.appscreen;

import entities.chat.CommonPrivatechat;
import entities.chat.PrivateChatFactory;
import interface_adapters.appscreen.AppScreenPresenter;
import interface_adapters.appscreen.Refresh;
import interface_adapters.chat.UserChats;
import screens.profile_screen.UserSearchUI;
import screens.chat_screen.ChatController;
import screens.chat_screen.ChatView;
import screens.profile_update_screen.UserModificationUI;
import use_cases.appscreen_use_case.*;
import use_cases.chat_initiation_use_case.ChatInputBoundry;
import use_cases.chat_initiation_use_case.ChatInteractor;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class AppScreen implements AppScreenPresenter, Refresh {

    private final JFrame jFrame;
    private JScrollPane jScrollPane;
    private final String currentUsername;
    private ArrayList<String> chats;


    /**
     Create an AppScreen object
     @param chats This is a list of chats given by the user (the list will always come as sorted with the
     most recent chats at the end of the list)
     */
    public AppScreen(String currentUsername, ArrayList<String> chats) {
        this.currentUsername = currentUsername;
        this.chats = chats;
        jFrame = new JFrame();
        jFrame.setSize(300, 500);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocation(300, 100);


        // top panel containing the buttons for creating a new chat
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,2));

        JButton addPrivateChat = new JButton("+ Private Chat");
        addPrivateChat.setPreferredSize(new Dimension(40, 30));


        // menu panel containing the buttons for searching for users or accessing profile settings
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(1,2));

        JButton searchUsers = new JButton("Search Users");
        JButton profileSettings = new JButton("Profile Settings");

        searchUsers.setPreferredSize(new Dimension(40, 30));
        profileSettings.setPreferredSize(new Dimension(30, 30));


        // adding the action listeners for the Search Users button
        searchUsers.addActionListener(e -> new UserSearchUI());

        // adding the action listeners for the Profile Settings button
        profileSettings.addActionListener(e -> new UserModificationUI());



        // adding the action listeners for the +private-chat and +group-chat buttons
        addPrivateChat.addActionListener(e -> {
            PrivateChatFactory privateChatFactory = new CommonPrivatechat();
            ChatInputBoundry inputBoundary = new ChatInteractor(privateChatFactory);
            ChatController controller = new ChatController(inputBoundary, currentUsername);
            new ChatView(controller, true);

        });

        topPanel.add(addPrivateChat);
        menuPanel.add(searchUsers);
        menuPanel.add(profileSettings);
        jFrame.add(topPanel, BorderLayout.NORTH);
        jFrame.add(menuPanel, BorderLayout.SOUTH);

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
        UserChats gateway = new UserChats(currentUsername);
        for (int i = this.chats.size() - 1; i > -1; i--) {

            ChatInfo chatInfo = new ChatInfo(gateway.getUserChats(currentUsername), chats.get(i));

            String chatName = chatInfo.getChatName();
            LocalDateTime lastUpdated = chatInfo.getLastMessageTime();

            jPanel.add(ChatButton.createButton(chatName, currentUsername, lastUpdated));
        }

        jPanel.setAlignmentY(Component.CENTER_ALIGNMENT);

        // set height of panel to appropriate size based on the number of chats
        jPanel.setPreferredSize(new Dimension(100, 60 * this.chats.size()));
        jPanel.setBorder(BorderFactory.createTitledBorder("My Chats"));


        // making the chat list scrollable
        makeScrollable(jPanel);

        jFrame.setVisible(true);

    }

    /**
     Make the chat list scrollable
     @param jPanel The panel containing the chats
     */
    private void makeScrollable(JPanel jPanel) {
        JScrollPane scrollFrame = new JScrollPane(jPanel);
        jScrollPane = scrollFrame;
        scrollFrame.setPreferredSize(new Dimension( 200,500));
        scrollFrame. getVerticalScrollBar().setUnitIncrement(5);
        jFrame.getContentPane().add(scrollFrame);
    }


    /**
     * Update the order of chats that appear on screen if there was a change to conversation history
     * This should be called if a new chat was added or if an existing chat has a new message
     */
    public void refreshScreen() {

        jFrame.remove(this.jScrollPane);

        // refresh the screen
        displayAppScreen();
    }

}
