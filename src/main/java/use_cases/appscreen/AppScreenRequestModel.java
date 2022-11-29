package use_cases.appscreen;

import entities.chat.Chat;
import java.util.ArrayList;

public class AppScreenRequestModel {
    private final String username;
    private final Chat chat;

    /**
     * Create a request model to update AppScreen
     * @param username Username of the current user
     * @param chat The new/updated chat
     */
    public AppScreenRequestModel(String username, Chat chat){
        this.username = username;
        this.chat = chat;
    }

    /**
     * Return an order list of chats
     * @return Ordered list of chats
     */
    public ArrayList<Chat> orderChats(){
        ChatOrder chatOrder  = new ChatOrder(username, chat);
        return chatOrder.changeOrder();
    }

}
