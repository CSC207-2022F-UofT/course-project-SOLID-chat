package entities.user_entities;

import interface_adapters.User.*;

import java.io.Serializable;

public abstract class User implements Serializable, Changeable, UserAuthenticationI {
    protected String username;
    protected String password;
    protected String email;
    boolean verified = false;
    boolean online = false;
//    protected ArrayList<Chat> chats;
    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
//        this.chats = new ArrayList<Chat>();
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

//    public ArrayList<Chat> getChats() {
//        return this.chats;
//    }

    @Override
    public Boolean PasswordMatch(String attempt){
        return (this.getPassword().equals(attempt));
    }

    @Override
//    from interface_adapters.User.Changeable
    public void changeFeature(String feature, String newFeature){
        if (feature == "Username"){
            this.username = newFeature;
        } else if (feature == "Password"){
            this.password = newFeature;
        } else if (feature == "Email"){
            this.email = newFeature;
        }
    }

}
