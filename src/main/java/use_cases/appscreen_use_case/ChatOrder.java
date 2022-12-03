package use_cases.appscreen_use_case;

import entities.chat.Chat;
import java.util.ArrayList;

public class ChatOrder {
    private final Chat chat;
    private final ArrayList<Chat> userChats;

    /**
     * Create a chat order object
     * @param userChats All the existing chats a user has
     * @param chat The given chat
     */
    public ChatOrder(ArrayList<Chat> userChats, Chat chat){
        this.chat = chat;
        this.userChats = userChats;

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
