package Entities.user_entities;
import UseCase.Changeable;
import java.io.Serializable;
public abstract class User implements Serializable, Changeable {
    protected String username;
    protected String password;
    protected String email;
    boolean verified = false;
    boolean online = false;
    public User(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
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

    @Override
//    from UseCase.Changeable
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