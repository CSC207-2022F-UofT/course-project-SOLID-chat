package use_cases.user_login_use_cases;

public interface UserLoginInputBoundary {
    void tryLogin();

    void setLoginCredentials(String username, String password);
}
