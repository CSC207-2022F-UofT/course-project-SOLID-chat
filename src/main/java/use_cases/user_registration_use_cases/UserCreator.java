package use_cases.user_registration_use_cases;

public interface UserCreator {
    void createUser(String username, String password, String email, String type);
}
