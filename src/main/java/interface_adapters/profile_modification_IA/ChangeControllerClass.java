package interface_adapters.profile_modification_IA;
import data_access.UserDatabase;
import entities.user_entities.User;

/**
 * profile_modification_IA.ChangeController makes ChangeControllerClass implement reportChange to invert the dependency
 */
public class ChangeControllerClass implements ChangeController{
    @Override
    public boolean reportChange(String username, String password, String feature, String newFeature) {
        UserDatabase db = new UserDatabase();
        if (db.UserExists(username)){
            User user = db.getUser(username);
            if (user.PasswordMatch(password) & user.getUsername().equals(username)){
                user.changeFeature(feature, newFeature);
                // this serializes the change
                db.modifyUser(username, user);
                return true;
            }
        }
        return false;
    }
    }
