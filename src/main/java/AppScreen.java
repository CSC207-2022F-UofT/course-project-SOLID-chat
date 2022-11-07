import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AppScreen implements AppScreenPresenter, AppScreenController {

    private final JFrame JFRAME;
    public ArrayList<Chat> chatOrdering;

    public AppScreen(ArrayList<Chat> chatOrdering) {
        this.JFRAME = new JFrame();
        this.chatOrdering = chatOrdering;

    }

    public ArrayList<Chat> getChatOrdering(){
        return this.chatOrdering;
    }

    @Override
    public void updateChatOrder(){

        /* any changes to conversation history or chat initiation (or deletion) should
        call changeChatOrdering so the order of chats in AppScreen can change
         */

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
