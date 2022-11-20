package use_cases.user_profile_display_use_case;

import entities.userEntities.User;

import java.io.File;

public class UserReader {
    public String[] UserReader(User user) {
        String email = user.getEmail();
        String username = user.getUsername();
        String[] out = new String[] {username, email};
        return out;
    }

}
