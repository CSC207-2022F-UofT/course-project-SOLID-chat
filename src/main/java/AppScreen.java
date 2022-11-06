import javax.swing.*;
import java.util.ArrayList;

public class AppScreen implements loginUsecase, AppScreenPresenter, AppScreenController {

    private final JFrame jFrame;
    protected ArrayList<Chat> chatOrdering;

    public AppScreen(ArrayList<Chat> chatOrdering) {
        this.jFrame = new JFrame();
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

        // getting the names of each chat to display
        String[] orderedChats = new String[this.chatOrdering.size()];

        for (int i = 0; i < chatOrdering.size(); i++){
            orderedChats[i] = chatOrdering.get(i).id; // id = name of chat
        }
        JList<String> chatButtons = new JList<>(orderedChats);
        this.jFrame.add(chatButtons);
        this.jFrame.setSize(200, 500);

        // making the window visible
        this.jFrame.setVisible(true);

        // terminating the program upon closing the window
        this.jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


}
