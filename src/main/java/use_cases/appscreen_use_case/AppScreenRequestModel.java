package use_cases.appscreen_use_case;

import entities.chat.Chat;
import java.util.ArrayList;

public class AppScreenRequestModel {
    private final Chat chat;

    /**
     * Create a request model to update AppScreen
     * @param chat The new/updated chat
     */
    public AppScreenRequestModel(Chat chat){
        this.chat = chat;
    }

    /**
     * Return an order list of chats
     * @param chats All the existing chats a user has
     * @return Ordered list of chats
     */
    public ArrayList<Chat> orderChats(ArrayList<Chat> chats){
        ChatOrder chatOrder  = new ChatOrder(chats, chat);
        return chatOrder.changeOrder();
    }

}
