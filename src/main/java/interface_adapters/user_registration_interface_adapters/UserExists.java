package interface_adapters.user_registration_interface_adapters;

public interface UserExists {
    boolean UserExists(String username, String password);
    boolean UserExists(String username);
}
