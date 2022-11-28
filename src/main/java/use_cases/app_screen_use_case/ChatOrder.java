package use_cases.app_screen_use_case;

import data_access.UserDatabase;
import entities.chat.Chat;
import interface_adapters.app_screen_interface_adapters.AppScreenController;

import java.io.File;
import java.util.ArrayList;

public class ChatOrder {

    private final String username;
    private final ArrayList<Chat> userChats;

    /**
     * Create a chat order object
     * @param username Username of the current user
     */
    public ChatOrder(String username){
        this.username = username;
        UserDatabase userDatabase = new UserDatabase(new File("user_accounts"));
        this.userChats = userDatabase.getUserChats(username);
    }

    /**
     * Return the chats that the given user has
     * @return List of the given user's chats
     */
    public ArrayList<Chat> getUserChats(){
        return this.userChats;
    }

    /**
     * Update the order of the chats
     * @param chatID The ID of the chat that has an update
     */
    public ArrayList<Chat> changeOrder(String chatID){

        AppScreenController appScreenController = new AppScreenController(this.username, chatID);
        Chat updatedChat = appScreenController.getChat();
        if (this.userChats.contains(updatedChat)) {
            this.userChats.remove(updatedChat);
            this.userChats.add(updatedChat);
        }
        else {
            this.userChats.add(updatedChat);
        }
        return this.userChats;
    }
}
