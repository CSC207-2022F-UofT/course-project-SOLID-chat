package app_screen_interface_adapters;

import Interface_adapters.Login;
import entities.User;
import data_access.UserDataBase;


import java.io.File;
import java.util.ArrayList;

public class UserAppScreenGateway implements Login {

    private final UserDatabase userDatabase;
    private final File userAccounts;
    private String username;
    private ArrayList<Chat> userChats;

    /**
     * Create gateway between user and appscreen
     */
    public UserAppScreenGateway(String username){
        this.username = username;

        // should be given the path of the file
        this.userAccounts = new File("\data_access\UserAccounts.csv");

        this.userDatabase = new UserDatabase(userAccounts);
        login();
    }


    /**
     * Log the user into the system
     */
    public void login(){;
        this.userChats = userDatabase.getUserChats(this.username);
        AppScreenLoader appScreenLoader = new AppScreenLoader(this.username, this.userChats);
    }

}
