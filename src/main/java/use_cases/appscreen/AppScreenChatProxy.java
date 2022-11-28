package use_cases.appscreen;

import entities.chat.Chat;
import interface_adapters.appscreen.AppScreenController;
import interface_adapters.appscreen.Refresh;

import java.util.ArrayList;

public class AppScreenChatProxy implements Refresh {

    private final String username;
    private final Chat chat;

    public AppScreenChatProxy(String username, Chat chat){
        this.username = username;
        this.chat = chat;
    }

    @Override
    public void refreshScreen() {
        AppScreenRequestModel requestModel = new AppScreenRequestModel(this.username, this.chat);
        ArrayList<Chat> newOrder = requestModel.orderChats();
        AppScreenController controller = new AppScreenController(this.username, this.chat.getChatID());
        controller.createGateway(newOrder);

        AppScreenResponseModel.refreshScreen();
    }
}
