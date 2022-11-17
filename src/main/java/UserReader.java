import java.io.File;

public class UserReader {
    public String[] UserReader(User user) {
        String email = user.getEmail();
        String username = user.getUsername();
        String[] out = new String[] {username, email};
        return out;
    }

}
