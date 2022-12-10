package interface_adapters.chat;

import data_access.UserDatabase;
import entities.chat.Chat;
import java.util.ArrayList;

public class UserChats implements UserChatGateway {
    private final ArrayList<Chat> userChats;

    /**
     * Create an object containing user chats
     * @param username Username of the current user
     */
    public UserChats(String username){

        UserDatabase userDatabase = new UserDatabase();
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

}
