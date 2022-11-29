package interface_adapters.appscreen;

import data_access.UserDatabase;
import entities.chat.Chat;
import entities.user_entities.User;
import use_cases.user_login_use_cases.Loginable;

import java.io.File;
import java.util.ArrayList;

public class UserAppScreenGateway implements Loginable {

    private final UserDatabase userDatabase = new UserDatabase(new File("user_accounts"));
    private final String username;
    private final ArrayList<Chat> userChats;

    /**
     * Create gateway between user and app screen
     */
    public UserAppScreenGateway(String username){
        this.username = username;
        this.userChats = userDatabase.getUserChats(this.username);
    }

    /**
     * Log the user into the system
     */
    public void login(){
        ArrayList<String> chatIDs = new ArrayList<>();

        for (Chat chat: userChats){
            chatIDs.add(chat.getChatID());
        }
        AppScreenLoader appScreenLoader = new AppScreenLoader(this.username, chatIDs);
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
