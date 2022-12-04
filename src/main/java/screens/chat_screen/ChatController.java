package screens.chat_screen;

import data_access.UserDatabase;
import entities.chat.PrivateChat;
import interface_adapters.appscreen.AppScreenChatProxy;
import use_cases.chat_initiation_use_case.ChatInputBoundry;
import use_cases.chat_initiation_use_case.ChatModel;

import javax.swing.*;
import java.awt.*;

//Interface adaptor of chat-Initiation.
/**
 * This class is ChatController , It Controls the ChatView and the ChatInteract in an indirect manner.
 * We use Interact of ChatInputBoundary and use the ChatModel to set the Recipient username taken from the UI.
 *
 */
public class ChatController {
    /**
     * ChatInputBoundary of the ChatController
     */

    ChatInputBoundry chatinputboundry;

    /**
     * an empty Private chat
     */
    PrivateChat newprivatechat;

    /**
     *  the current username currently using the UI.
     */

    String currentusername;

    /**
     * Construct a new message
     * @param chatinputboundry chat input boundary Interface obj
     * @param currentusername current username
     */

    public ChatController(ChatInputBoundry chatinputboundry, String currentusername) {
        this.chatinputboundry = chatinputboundry;
        this.currentusername= currentusername;
    }

    /**
     * creating a chatModel with the Rcipient username that user just typed in the UI.(username text field)
     * also checks if the typed username exist or not.
     * @return ChatModel
     */

    // this method is used in UI to set the recipient username
    public ChatModel create (String username){
        ChatModel chatmodel = new ChatModel(username);

        UserDatabase userdatabase = new UserDatabase();

        // checks whether is typed username exist in or not if not open a window with error
        //and if yes create the ChatModel

        if (!(userdatabase.UserExists(username))) {


            JFrame frame = new JFrame();
            JOptionPane.showMessageDialog(frame, "Eggs are not supposed to be green.");
        }
        // create a private chat obj
        this.newprivatechat = chatinputboundry.create(chatmodel);

        //Adding the chat to dashboard App-screen and then update it in database
        new AppScreenChatProxy(currentusername, this.newprivatechat).proxyChat();
        return chatmodel;


    }

    /**
     * a getter for the new made private chat.( will be used in testing )
     * @return  PrivateChat
     */

    public PrivateChat getNewprivatechat() {
        return newprivatechat;
    }}


