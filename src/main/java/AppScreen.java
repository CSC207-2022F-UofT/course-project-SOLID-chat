import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import testerEntities.*;


public class AppScreen implements AppScreenPresenter, AppScreenController, ChatName, Refresh {

    final JFrame jFrame;
    final String currentUserName;
    private ArrayList<Chat> chats;


    /**
    Create an AppScreen object
    @param chats This is a list of chats given by the user (the list will always come as sorted with the
    most recent chats at the end of the list)
     */
    public AppScreen(String currentUserName, ArrayList<Chat> chats) {
        this.currentUserName = currentUserName;
        this.chats = chats;
        this.jFrame = new JFrame();
        this.jFrame.setSize(300, 500);
        this.jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        // top panel containing the buttons for creating a new chat
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,2));
        JButton addPrivateChat = new JButton("+ Private Chat");
        JButton addGroupChat = new JButton("+ Group Chat");

        addPrivateChat.setPreferredSize(new Dimension(40, 30));
        addGroupChat.setPreferredSize(new Dimension(40, 30));

        // TODO: implement the action listeners for +PrivateChat and +GroupChat

        topPanel.add(addPrivateChat);
        topPanel.add(addGroupChat);
        this.jFrame.add(topPanel, BorderLayout.NORTH);

        this.chats = chats;
        displayAppScreen();

    }

    /**
     * Update the order of the chats
     * @param chat The chat that has an update
     */
    @Override
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
            b.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    /* TODO: call chatView to open the display the window (?) for chat
                     - not sure if AppScreen and ChatView would be combined into one window, or
                       two separate windows
                     */
                }
            });
            jPanel.add(b);
        }

        jPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
        jPanel.setPreferredSize(new Dimension(100, 500));
        jPanel.setMaximumSize(new Dimension(100, 500));
        jPanel.setBorder(BorderFactory.createTitledBorder("My Chats"));

        //jFrame.getContentPane().add(jPanel);

        // making the chat list scrollable
        scrollableChats(jPanel);

        this.jFrame.setVisible(true);

    }

    /**
    Make the chat list scrollable
    @param jPanel The panel containing the chats
     */
    private void scrollableChats(JPanel jPanel) {
        JScrollPane scrollFrame = new JScrollPane(jPanel);
        //scrollFrame.setAutoscroll(true);
        scrollFrame.setPreferredSize(new Dimension( 200,500));
        this.jFrame.add(scrollFrame);
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
     * Return true if the given chat as an update to its conversation history
     * @param chat The given chat
     * @return true/false
     */
    @Override
    public boolean hasUpdate(Chat chat) {
        return this.chats.get(this.chats.size() - 1) != chat;
    }

    /**
     * Update the screen if the given chat has been updated
     * @param chat The given chat
     */
    @Override
    public void updateScreen(Chat chat) {
        if (hasUpdate(chat)){
            updateChatOrder(chat);

            // refresh the screen
            displayAppScreen();
        }
    }
}
