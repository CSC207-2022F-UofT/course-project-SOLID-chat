package interface_adapters.User;

public interface UserExists {
    boolean UserExists(String username, String email);
    boolean UserExists(String username);
}
