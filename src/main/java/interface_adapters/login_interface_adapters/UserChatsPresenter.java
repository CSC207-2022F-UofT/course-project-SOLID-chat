package interface_adapters.login_interface_adapters;

import use_cases.user_login_use_cases.UserLoginOutputBoundary;

import java.util.ArrayList;
import java.util.List;
/**
 * Just a bunch of getters and setters
 * **/
public class UserChatsPresenter implements UserLoginOutputBoundary {
    private List<String> chats;
    private boolean notExists;
    private boolean notMatched;
    private String username;

    public UserChatsPresenter(){
        this.chats = new ArrayList<>();
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public void setChats(List<String> chats) {
        this.chats = chats;
    }
    public List<String> getChats(){
        return this.chats;
    }

    @Override
    public void setUserNotExists(boolean notExists) {
        this.notExists = notExists;
    }

    public boolean isNotExists() {
        return notExists;
    }

    @Override
    public void setPasswordNotMatched(boolean notMatched) {
        this.notMatched = notMatched;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public boolean isNotMatched() {
        return notMatched;
    }
}
