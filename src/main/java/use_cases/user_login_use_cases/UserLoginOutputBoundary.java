package use_cases.user_login_use_cases;

import java.util.List;
/**
 * Objects that implement this interface are presenters that communicate with the view
 * and the login interactor in order to implement login
 * **/
public interface UserLoginOutputBoundary {
    void setUsername(String username);
    void setChats(List<String> chats);
    void setUserNotExists(boolean notExists);
    void setPasswordNotMatched(boolean notMatched);

    String getUsername();
    List<String> getChats();
    boolean isNotExists();
    boolean isNotMatched();
}
