package interface_adapters.appscreen;

import data_access.UserDatabase;
import entities.chat.Chat;
import entities.user_entities.User;

import java.io.File;
import java.util.ArrayList;

public class UserAppScreenGateway {

    private final UserDatabase userDatabase = new UserDatabase(new File("user_accounts"));
    private final String username;

    /**
     * Create gateway between user and app screen
     */
    public UserAppScreenGateway(String username){
        this.username = username;
        try{
            // see if we're able to get chats given this username
            userDatabase.getUserChats(username);
        } catch (Exception e) {
            throw new RuntimeException("User with this username does not exist");
        }

    }

    /**
     * Update and save the order of chats for a user in UserDatabase
     * @param userChats Updated list of chats in order
     */
    public void updateUserChatList(ArrayList<Chat> userChats){
        User currentUser = this.userDatabase.getUser(username);
        currentUser.getUserChats().clear();
        currentUser.getUserChats().addAll(userChats);
        this.userDatabase.modifyUser(username, currentUser);

    }

}
