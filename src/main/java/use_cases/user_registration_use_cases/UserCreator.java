
package use_cases.user_registration_use_cases;
/**
 * Interface that has a method which represents the creation of a user
 * */
public interface UserCreator {
    void createUser(String username, String password, String email, String type);
}
