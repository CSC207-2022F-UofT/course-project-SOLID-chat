package entities.user_entities;

import entities.chat.Chat;
import interface_adapters.profile_modification_IA.UserAuthenticationI;
import use_cases.user_attribute_modification_use_case.Changeable;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable, Changeable, UserAuthenticationI {
    protected String username;
    protected String password;
    protected String email;

    protected ArrayList<Chat> userChats;
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
        if ("Username".equals(feature)){
            this.username = newFeature;
        } else if ("Password".equals(feature)){
            this.password = newFeature;
        } else if ("Email".equals(feature)){
            this.email = newFeature;
        }
    }

    @Override
    public Boolean PasswordMatch(String attempt){
        return (this.getPassword().equals(attempt));
    }

    public ArrayList<Chat> getChats() {
        return this.userChats;
    }


}
