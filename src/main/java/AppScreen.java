import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;


public class AppScreen implements AppScreenPresenter, AppScreenController {

    final JFrame JFRAME;
    ArrayList<Chat> chats;


    /*
    Create an AppScreen object
    @param chats This is a list of chats given by the user
     */
    public AppScreen(ArrayList<Chat> chats) {
        this.JFRAME = new JFrame();
        this.chats = chats;
        this.checkChatOrder();

    }

    /*
    @return boolean This returns true if and only if AppScreen's chats are ordered by time,
    otherwise return false.
     */
    public boolean isOrdered(){

        LocalTime currentTime = LocalTime.now();
        for (Chat c: this.chats){

            LocalTime chatTime = c.convHist.latestMessage().getTimeStamp();

            // check if the time of a chat's latest update in conversation history is before currentTime
            if (chatTime.isBefore(currentTime)){
                return false;
            }
            // Reassign the current time to the latest chat's updated time
            currentTime = chatTime;
        }
        return true;

    }

    /*
    Update the order of the chats by latest conversation times - Most recent chats would appear
    at the top and descend chronologically down
     */
    public void updateChatOrder(){

        /* any changes to conversation history or chat initiation (or deletion) should
        call updateChatOrder so the order of chats in AppScreen can change
         */
        displayAppScreen();

    }

    /*
    Check whether AppScreen's current list of chats is ordered by time
     */
    public void checkChatOrder(){
        if (isOrdered()){
            displayAppScreen();
        }
        else{
            updateChatOrder();
        }

    }

    @Override
    /*
    Display a screen containing an ordered list of chats to the user based on latest conversation times
     */
    public void displayAppScreen(){

        JPanel jPanel = new JPanel();

        // getting the names of each chat to display and creating buttons for each chat
        for (int i = 0; i < chatOrdering.size(); i++){

            JButton b = new JButton(chatOrdering.get(i).name);

            // defines the action of opening a chat when a chat is clicked on
            b.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    // call chatView to open the display the window (?) for chat
                    /* not sure if AppScreen and ChatView would be combined into one window, or
                       two separate windows
                     */
                }
            });
            jPanel.add(b);
        }

        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

        // making the chat list scrollable
        scrollableChats(jPanel);

        this.JFRAME.setSize(200, 500);
        this.JFRAME.setVisible(true);
        this.JFRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

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
