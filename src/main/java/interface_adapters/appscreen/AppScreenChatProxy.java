package interface_adapters.appscreen;

import entities.chat.Chat;
import interface_adapters.chat.UserChats;
import use_cases.appscreen_use_case.AppScreenRequestModel;
import use_cases.appscreen_use_case.AppScreenResponseModel;

import java.util.ArrayList;

public class AppScreenChatProxy {

    private final String username;
    private final Chat chat;

    /**
     * Create a proxy between app screen and a chat
     * @param username Username of the current user
     * @param chat The new/updated chat
     */
    public AppScreenChatProxy(String username, Chat chat){
        this.username = username;
        this.chat = chat;
    }

    /**
     * Main source for managing chat order and updating it in user database (for a single user)
     */
    public void proxyChat() {
        // get the new chat order
        AppScreenRequestModel requestModel = new AppScreenRequestModel(this.chat);
        ArrayList<Chat> oldOrder = new UserChats(this.username).getUserChats(username);
        ArrayList<Chat> newOrder = requestModel.orderChats(oldOrder);

        // update the user's chat list in user database
        AppScreenController controller = new AppScreenController(this.username);
        controller.createGateway(newOrder);

        // update the AppScreen UI
        AppScreenResponseModel.refreshScreen();
    }
}
