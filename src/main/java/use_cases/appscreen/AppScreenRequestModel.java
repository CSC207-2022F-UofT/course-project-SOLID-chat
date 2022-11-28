package use_cases.appscreen;

import entities.chat.Chat;
import interface_adapters.appscreen.AppScreenController;

import java.util.ArrayList;

public class AppScreenRequestModel {

    private String username;
    private Chat chat;
    public AppScreenRequestModel(String username, Chat chat){
        this.username = username;
        this.chat = chat;
    }

    public ArrayList<Chat> orderChats(){
        ChatOrder chatOrder  = new ChatOrder(username, chat);
        return chatOrder.changeOrder();
    }

}
