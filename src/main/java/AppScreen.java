import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.ArrayList;

public class AppScreen implements AppScreenPresenter, AppScreenController {

    private final JFrame JFRAME;
    private ArrayList<Chat> chats;

    public AppScreen(ArrayList<Chat> chats) {
        this.JFRAME = new JFrame();
        this.chats = chats;
        this.checkChatOrder();

    }

    public ArrayList<Chat> getChatOrdering(){
        return new ArrayList<Chat>(this.chatOrdering);
    }

    public boolean isOrdered(){

        LocalTime currentTime = LocalTime.now();
        for (Chat c: this.chats){

            // check if the time of a chat's latest update in conversation history is before currentTime
            if (c.convHist.getLatestTime().isBefore(currentTime)){
                return false;
            }
            // Reassign the current time to the latest chat's updated time
            currentTime = c.convHist.getLatestTime();
        }
        return true;

    }

    public void updateChatOrder(){

        /* any changes to conversation history or chat initiation (or deletion) should
        call updateChatOrder so the order of chats in AppScreen can change
         */
        displayAppScreen();

    }

    public void checkChatOrder(){
        if (isOrdered()){
            displayAppScreen();
        }
        else{
            updateChatOrder();
        }

    }

    @Override
    public void displayAppScreen(){

        JPanel jPanel = new JPanel();

        // getting the names of each chat to display and creating buttons for each chat
        for (int i = 0; i < chatOrdering.size(); i++){

            JButton b = new JButton(chatOrdering.get(i).id); // id could be replaced with a user/chat's name

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

        // setting the layout of chats to appear on the screen and the size of the window
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));
        this.JFRAME.setSize(200, 500);
        this.JFRAME.add(jPanel);

        // making the window visible
        this.JFRAME.setVisible(true);

        // terminating the program upon closing the window
        this.JFRAME.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
