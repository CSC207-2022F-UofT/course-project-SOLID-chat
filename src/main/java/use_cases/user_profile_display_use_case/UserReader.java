package use_cases.user_profile_display_use_case;
import entities.user_entities.User;

/**
 * Collects user information from user entity.
 */
public class UserReader {
    public String[] ProfileReader(User user) {
        String email = user.getEmail();
        String username = user.getUsername();
        return new String[] {username, email};
    }

}
