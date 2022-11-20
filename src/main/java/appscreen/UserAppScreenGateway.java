package appscreen;

import java.util.ArrayList;

public class UserAppScreenGateway {

    private final UserDataBase userDataBase;
    private String username;
    private ArrayList<Chat> userChats;

    /**
     * Create gateway between user and appscreen
     * @param userDataBase The user database
     */
    public UserAppScreenGateway(UserDataBase userDataBase){
        this.userDataBase = userDataBase;
    }

    /**
     * Log the user into the system
     * @param user The current user
     */
    public void login(User user){
        this.username = user.getUsername();
        this.userChats = userDataBase.getUserChats(this.username);
        AppScreenLoader appScreenLoader = new AppScreenLoader(this.username, this.userChats);
    }

}
