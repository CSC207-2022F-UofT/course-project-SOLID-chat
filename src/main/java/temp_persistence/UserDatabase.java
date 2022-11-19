package temp_persistence;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import conversation_history_use_case.ConvHistDsRequestModel;
import conversation_history_use_case.MsgSenderDsRequestModel;
import entities.*;

//public class temp_persistence.UserDatabase implements UserExists, UserCreator{
public class UserDatabase{  // this needs to extend an interface
    Map<String, User> temp_accounts;
    File accounts;
    public UserDatabase(File accounts){
        this.accounts = accounts;
        this.temp_accounts = new HashMap<String, User>();
        // Can have code to populate temp_accounts
    }

    /**
     * Pushes a new message to a chat's conversation history (in memory not persisting storage)
     * @param dsRequestModel input data containing user ID, chat ID, message content
     */
    public void saveMessage(MsgSenderDsRequestModel dsRequestModel) {
        String userID = dsRequestModel.getUserID();
        String chatID = dsRequestModel.getChatID();
        Message message = dsRequestModel.getMessage();

        // Find chat under specified User
        Chat chat = temp_accounts.get(userID).getChats().get(chatID);

        chat.addMessage(message);
    }

    /**
     * Gets a chat's conversation history (from memory not persisting storage)
     * @param dsRequestModel input data containing user ID, chat ID
     * @return a chat's conversation history
     */
    public ArrayList<Message> getConversationHistory(ConvHistDsRequestModel dsRequestModel) {
        String userID = dsRequestModel.getUserID();
        String chatID = dsRequestModel.getChatID();

        // Find chat under specified User
        Chat chat = temp_accounts.get(userID).getChats().get(chatID);

        return Chat.getConversationHistory();
    }
}