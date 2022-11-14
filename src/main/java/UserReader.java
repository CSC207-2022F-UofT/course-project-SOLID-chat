import java.io.File;

public class UserReader {
    public String[] UserReader(User user) {
        String email = user.getEmail();
        String[] out = new String[] {username, email};
        return out;
    }

}
