package appscreen;

import testerEntities.User;

import java.util.ArrayList;

public class UserAppScreenGateway implements Username {

    private final UserDatabase userDatabase;
    private String username;
    private ArrayList<Chat> userChats;

    /**
     * Create gateway between user and appscreen
     * @param userDatabase The user database
     */
    public UserAppScreenGateway(UserDatabase userDatabase){
        this.userDatabase = userDatabase;
    }

    /**
     * Log the user into the system
     * @param user The current user
     */
    public void login(User user){
        this.username = getUsername(user);
        this.userChats = userDatabase.getUserChats(this.username);
        AppScreenLoader appScreenLoader = new AppScreenLoader(this.username, this.userChats);
    }

    /**
     * Get the username of the user
     * @param user The current user
     * @return Username of the user
     */
    @Override
    public String getUsername(User user) {
        return user.getUsername();
    }
}
