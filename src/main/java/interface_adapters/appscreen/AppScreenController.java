package interface_adapters.appscreen;

import data_access.UserDatabase;
import entities.chat.Chat;
import use_cases.appscreen.ChatInfo;
import use_cases.appscreen.ChatOrder;

import java.io.File;
import java.util.ArrayList;

public class AppScreenController{

    private final String username;
    private final String chatID;


    /**
     * Create an app screen controller
     * @param username Username of the user
     * @param chatID ID the chat with an update
     */
    public AppScreenController(String username, String chatID){
        this.username = username;
        this.chatID = chatID;

    }

    /**
     * Return the chat with the given ID
     * @return Chat with given ID
     */
    public Chat getChat(){
        ChatInfo chatInfo = new ChatInfo(this.username, this.chatID);
        return chatInfo.getChat();

    }

    /**
     * Controller to update the screen and change the order chats of in user database
     */
    public void updateScreen(){
        ChatOrder chatOrder = new ChatOrder(this.username);
        ArrayList<Chat> newOrder = chatOrder.changeOrder(getChat());
        createGateway(newOrder);

    }

    /**
     * Create the gateway to save a user's chat list order in the user database
     */
    public void createGateway(ArrayList<Chat> newOrder){
        UserAppScreenGateway gateway = new UserAppScreenGateway(this.username,
                new UserDatabase(new File("user_accounts")));
        try{
            gateway.updateUserChatList(this.username, newOrder);
        } catch (NullPointerException e) {
            throw new NullPointerException("New chat list is empty");
        }
        catch (Exception e){
            throw new RuntimeException("Unable to update chat order");
        }
    }

}
