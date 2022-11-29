package use_cases.appscreen;

import data_access.UserDatabase;
import entities.chat.Chat;
import java.io.File;
import java.util.ArrayList;

public class ChatOrder {
    private final Chat chat;
    private final ArrayList<Chat> userChats;

    /**
     * Create a chat order object
     * @param username The username of the user
     * @param chat The given chat
     */
    public ChatOrder(String username, Chat chat){
        this.chat = chat;
        this.userChats = new UserDatabase(new File("user_accounts")).getUserChats(username);

    }

    /**
     * Update and return the order of the chats (most-recent chats will be at the end of the list with
     * the given chat being the most recent)
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
