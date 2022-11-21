package interface_adapters.app_screen_interface_adapters;

import java.util.ArrayList;
import interface_adapters.*;
import entities.*;
import data_access.UserDatabase;
import tutorial.Chat;

import java.util.ArrayList;

public class UserAppScreenGateway implements Login {

    private final UserDatabase userDatabase;
    private final String username;
    private ArrayList<Chat> userChats;

    /**
     * Create gateway between user and appscreen
     */
    public UserAppScreenGateway(String username){
        this.username = username;
        this.userDatabase = new UserDatabase();
        login();
    }

    /**
     * Log the user into the system
     */
    public void login(){;
        this.userChats = this.userDatabase.getUserChats(this.username);
        AppScreenLoader appScreenLoader = new AppScreenLoader(this.username, this.userChats);
    }

}
