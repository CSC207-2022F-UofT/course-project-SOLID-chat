package use_cases.user_login_use_case;

public interface UserCreator {
    void createUser(String username, String password, String email, String type);
}
