package interface_adapters.chat;

import data_access.UserDatabase;
import entities.chat.Chat;
import java.io.File;
import java.util.ArrayList;

public class UserChats implements UserChatGateway {
    private final ArrayList<Chat> userChats;

    /**
     * Create an object containing user chats
     * @param username Username of the current user
     */
    public UserChats(String username){
        UserDatabase userDatabase = new UserDatabase(new File("user_accounts"));
        this.userChats = userDatabase.getUserChats(username);
    }

    /**
     * Return the current user's chats
     * @param username Username of the user
     * @return User chats
     */
    @Override
    public ArrayList<Chat> getUserChats(String username) {
        return this.userChats;
    }

    /**
     * Return the chat of the given user and specified chat ID
     * @return a chat
     */
    public Chat getChat(String chatID){
        try{
            for (Chat chat: userChats){
                if (chat.getChatID().equals(chatID)){
                    return chat;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to get indicated chat");
        }
        return null;
    }

}
