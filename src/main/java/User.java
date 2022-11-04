import java.io.Serializable;
public class User implements Serializable{
    private String username;
    private String password;
    private String email;
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
    public String getPassword(){
        return this.password;
    }

}
