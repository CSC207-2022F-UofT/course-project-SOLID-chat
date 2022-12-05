package interface_adapters.appscreen;

import entities.chat.Chat;
import java.util.ArrayList;

public class AppScreenController{
    private final String username;

    /**
     * Create an app screen controller
     * @param username Username of the user
     */
    public AppScreenController(String username){
        this.username = username;

    }

    /**
     * Create the gateway to save a user's chat list order in the user database
     */
    public void createGateway(ArrayList<Chat> newOrder){
        UserAppScreenGateway gateway = new UserAppScreenGateway(this.username);
        try{
            gateway.updateUserChatList(newOrder);
        } catch (NullPointerException e) {
            throw new NullPointerException("New chat list is empty");
        }
        catch (Exception e){
            throw new RuntimeException("Unable to update chat order");
        }
    }

}
