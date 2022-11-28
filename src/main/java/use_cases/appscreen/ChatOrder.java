package use_cases.appscreen;

import data_access.UserDatabase;
import entities.chat.Chat;
import interface_adapters.Chat.UserChatGateway;

import java.io.File;
import java.util.ArrayList;

public class ChatOrder {

    private final String username;
    private final Chat chat;

    private final ArrayList<Chat> userChats;

    /**
     * Create a chat order object
     * @param username The username of the user
     * @param chat The given chat
     */
    public ChatOrder(String username, Chat chat){
        this.username = username;
        this.chat = chat;
        this.userChats = new UserDatabase(new File("user_accounts")).getUserChats(username);

    }

    /**
     * Return the chats that the given user has
     * @return List of the given user's chats
     */
    public ArrayList<Chat> getUserChats(){
        return this.userChats;
    }

    /**
     * Update the order of the chats and return the new lisst
     */
    public ArrayList<Chat> changeOrder(){

        if (this.userChats.contains(this.chat)) {
            this.userChats.remove(this.chat);
            this.userChats.add(this.chat);
        }
        else {
            this.userChats.add(this.chat);
        }
        return this.userChats;
    }
}
