
package interface_adapters.user_registration_interface_adapters;
public interface UserExists {
    boolean UserExists(String username, String email);
    boolean UserExists(String username);
}
