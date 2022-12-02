package use_cases.user_login_use_cases;

public interface UserLoginInputBoundary {
    void login(String username, String password);

    UserLoginOutputBoundary getChatsPresenter();

}
