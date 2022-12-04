package interface_adapters.user_search_IA;
import data_access.UserDatabase;
import entities.user_entities.User;
import use_cases.user_profile_display_use_case.UserReader;

/**
 * User_search_IA.UserPresenter makes us implement showProfile to invert the dependency
 */
public class UserPresenterClass implements UserPresenter{
    @Override
    public String showProfile(String username) {
        //    setting up access to the database of users:
        UserDatabase db = new UserDatabase();
        if (db.UserExists(username)){
            User user = db.getUser(username);
            UserReader reader = new UserReader();
            String[] features = reader.ProfileReader(user);
            String email = features[1];
            return("<html>Username: " + username + "<br>Email: " + email + "</html>");
        }
        else{
            return("User with given username does not exist.");
        }
    }
}
