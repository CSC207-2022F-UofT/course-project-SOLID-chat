package use_cases.appscreen;

import data_access.UserDatabase;
import entities.chat.Chat;

import java.io.File;
import java.util.ArrayList;

public class ChatOrder {

    private final ArrayList<Chat> userChats;

    /**
     * Create a chat order object
     * @param username Username of the current user
     */
    public ChatOrder(String username){
        UserDatabase userDatabase = new UserDatabase(new File("user_accounts"));
        this.userChats = userDatabase.getUserChats(username);
    }

    /**
     * Return the chats that the given user has
     * @return List of the given user's chats
     */
    public ArrayList<Chat> getUserChats(){
        return this.userChats;
    }

    /**
     * Update the order of the chats
     * @param updatedChat The chat that has an update
     */
    public ArrayList<Chat> changeOrder(Chat updatedChat){

        if (this.userChats.contains(updatedChat)) {
            this.userChats.remove(updatedChat);
            this.userChats.add(updatedChat);
        }
        else {
            this.userChats.add(updatedChat);
        }
        return this.userChats;
    }
}
