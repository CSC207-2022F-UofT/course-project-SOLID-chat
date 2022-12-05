package use_cases.user_login_use_cases;

public interface UserLoginInputBoundary {
    /** Use case that is responsible for logging in the user*/
    void login(String username, String password);

    /** Returns a presenter object that communicates with the view, about next steps**/
    UserLoginOutputBoundary getChatsPresenter();

}
