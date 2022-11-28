
package use_cases.user_registration_use_cases;
public interface UserExists {
    boolean UserExists(String username, String email);
    boolean UserExists(String username);
}
