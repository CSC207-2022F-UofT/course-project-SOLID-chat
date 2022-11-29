package entities.user_entities;

import data_access.UserDatabase;
import entities.chat.Chat;
import interface_adapters.profile_modification_IA.UserAuthenticationI;
import use_cases.user_attribute_modification_use_case.Changeable;
import interface_adapters.app_screen_interface_adapters.UserAppScreenGateway;
import use_cases.user_login_use_cases.Loginable;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable, Changeable, Loginable, UserAuthenticationI {
    protected String username;
    protected String password;
    protected String email;

    protected ArrayList<Chat> userChats;
    boolean verified = false;
    boolean online = false;
    public User(String username, String password, String email, ArrayList<Chat> userChats){
        this.username = username;
        this.password = password;
        this.email = email;
        this.userChats = userChats;
    }
    public String getEmail(){
        return this.email;
    }
    public String getUsername(){
        return this.username;
    }
    private String getPassword(){
        return this.password;
    }
    public ArrayList<Chat> getUserChats(){
        return  this.userChats;
    }

    @Override
//    from Changeable
    public void changeFeature(String feature, String newFeature){
        if (feature == "Username"){
            this.username = newFeature;
        } else if (feature == "Password"){
            this.password = newFeature;
        } else if (feature == "Email"){
            this.email = newFeature;
        }
    }

    @Override
    public Boolean PasswordMatch(String attempt){
        return (this.getPassword().equals(attempt));
    }

    public void login(){
        UserAppScreenGateway appScreenGateway = new UserAppScreenGateway(this.getUsername(), new UserDatabase(new File("user_accounts")));
        appScreenGateway.login();
    }

    public ArrayList<Chat> getChats() {
        return this.userChats;
    }


}
