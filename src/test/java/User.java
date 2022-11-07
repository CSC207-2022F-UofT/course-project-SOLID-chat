import java.util.ArrayList;

// User Tester Class (prototype user)
public class User {

    private String username;
    private String password;
    private String email;
    private ArrayList<Chat> chats;

    public User(String username, String password, String email){

        this.username = username;
        this.password = password;
        this.email = email;
        this.chats = new ArrayList<>();
    }

    public String getUsername(){
        return this.username;
    }
}
