package interface_adapters.appscreen;

import entities.chat.Chat;
import use_cases.appscreen.AppScreenRequestModel;
import use_cases.appscreen.AppScreenResponseModel;
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
        AppScreenRequestModel requestModel = new AppScreenRequestModel(this.username, this.chat);
        ArrayList<Chat> newOrder = requestModel.orderChats();

        // update the user's chat list in user database
        AppScreenController controller = new AppScreenController(this.username);
        controller.createGateway(newOrder);

        // update the AppScreen UI
        AppScreenResponseModel.refreshScreen();
    }
}
