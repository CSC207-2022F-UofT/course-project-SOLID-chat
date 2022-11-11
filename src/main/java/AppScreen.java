import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class AppScreen implements AppScreenPresenter, AppScreenController {

    final JFrame JFRAME;
    final User CURR_USER;
    public ArrayList<Chat> chats;


    /*
    Create an AppScreen object
    @param chats This is a list of chats given by the user (the list will always come as sorted with the
    most recent chats at the end of the list)
     */
    public AppScreen(ArrayList<Chat> chats, User user) {
        this.CURR_USER = user;
        this.JFRAME = new JFrame();
        this.JFRAME.setSize(200, 500);
        this.JFRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.chats = chats;

        displayAppScreen();

    }

    /*
    Return true if a chat has an update (e.g. new message, new chat created, changes to conversation
    history), and add/move the chat to the end of the chats list.
    Note: If a chat has no update, this method shouldn't be called.
    @param chat The chat with the new update
    @return true
     */
    public boolean hasUpdate(Chat chat){

        if (this.chats.contains(chat)) {
            this.chats.remove(chat);
            ArrayList<Chat> temp = new ArrayList<>(this.chats);
            temp.add(chat);
            this.chats = temp;
        }
        else {
            this.chats.add(chat);
        }
        // refresh the screen
        this.JFRAME.revalidate();
        return true;
    }


    /*
    Display a screen containing an ordered list of chats to the user based on latest conversation times
     */
    public void displayAppScreen(){

        JPanel jPanel = new JPanel();

        // getting the names of each chat to display and creating buttons for each chat
        for (Chat chat : chats) {

            String chatName = getName(chat);
            JButton b = new JButton(chatName);

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
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

        // making the chat list scrollable
        scrollableChats(jPanel);

        this.JFRAME.setVisible(true);

    }

    /*
    Return the username of the user that the current user is conversing with. Right now, this method
    only works for private chats, and would need to add another case for group chats.
    @param chat The subject chat
    @return The username to be displayed
     */
    public String getName(Chat chat){
        for (User user: chat.getUsers()){
            if (!(user.equals(this.CURR_USER))){
                return user.getUsername();
            }
        }
        throw new RuntimeException("The current user is not part of this chat");
    }

    /*
    Make the chat list scrollable
    @param jPanel The panel containing the chats
     */
    private void scrollableChats(JPanel jPanel) {
        JScrollPane scrollFrame = new JScrollPane(jPanel);
        scrollFrame.setAutoscrolls(true);
        scrollFrame.setPreferredSize(new Dimension( 200,500));
        this.JFRAME.add(scrollFrame);
    }


}
