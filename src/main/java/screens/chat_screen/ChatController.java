package screens.chat_screen;
import data_access.UserDatabase;
import entities.chat.Chat;
import entities.chat.PrivateChat;
import interface_adapters.appscreen.AppScreenChatProxy;
import use_cases.chat_initiation_use_case.ChatInputBoundry;
import use_cases.chat_initiation_use_case.ChatModel;


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

    UserDatabase db = new UserDatabase();

    //check whether is typed username exist in our database  if yes create a new privatechat

    if(db.UserExists(username)) {
       // check if the current user already has a chat with user

        for (Chat chat : db.getUserChats(currentusername)) {
            if (chat.getName().equals(username)) {
                return null;
            }
        }

        //create a private chat obj

        this.newprivatechat = chatinputboundry.create(chatmodel);

        //adding the chat to dashboard App-screen and then update in data base
        new AppScreenChatProxy(currentusername,this.newprivatechat).proxyChat();
        return chatmodel;

    }return null;}

    /**
     * a getter for the new made private chat.( might be used in testing )
     * @return  PrivateChat
     */

    public PrivateChat getNewprivatechat() {
        return newprivatechat;
    }



}


