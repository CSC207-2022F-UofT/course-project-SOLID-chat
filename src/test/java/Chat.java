import java.util.ArrayList;

// Chat Tester Class (protype chat)
public class Chat {

    ArrayList<User> users;
    ArrayList<String> convHist; // using String in place of messages entity

    public Chat(ArrayList<User> users){
        this.users = users;
        this.convHist = new ArrayList<>();
    }

    public void addUser(User user){
        this.users.add(user);
    }
}
