import java.io.File;

public class UserReader {
    UserDatabase db = UserDatabase(accounts);

    public String[] UserReader(String username) {
        User user = db.getUser(username);
        String email = user.getEmail();
        String[] out = new String[] {username, email};
        return out;
    }

}
