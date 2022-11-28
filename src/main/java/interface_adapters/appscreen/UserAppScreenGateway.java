package interface_adapters.appscreen;

import data_access.UserDatabase;
import entities.chat.Chat;
import entities.user_entities.User;
import interface_adapters.login_interface_adapters.Login;

import java.util.ArrayList;

public class UserAppScreenGateway implements Login {

    private final UserDatabase userDatabase;
    private final String username;

    /**
     * Create gateway between user and appscreen
     */
    public UserAppScreenGateway(String username, UserDatabase userDatabase){
        this.username = username;
        this.userDatabase = userDatabase;
    }

    /**
     * Log the user into the system
     */
    public void login(){
        ArrayList<Chat> userChats = this.userDatabase.getUserChats(this.username);
        AppScreenLoader appScreenLoader = new AppScreenLoader(this.username, userChats);
        appScreenLoader.openScreen();
    }

    /**
     * Update and save the order of chats for a user in UserDatabase
     * @param username Username of the current user
     * @param userChats Updated list of chats in order
     */
    public void updateUserChatList(String username, ArrayList<Chat> userChats){
        User currentUser = this.userDatabase.getUser(username);
        currentUser.getUserChats().clear();
        currentUser.getUserChats().addAll(userChats);
        this.userDatabase.modifyUser(username, currentUser);

    }
}
