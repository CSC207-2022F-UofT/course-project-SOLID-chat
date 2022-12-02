package screens.login_screen;
import interface_adapters.login_interface_adapters.UserLoginViewI;
import screens.appscreen.AppScreen;
import use_cases.user_login_use_cases.UserLoginOutputBoundary;

import java.util.ArrayList;

public class AppScreenCreator implements UserLoginViewI {
    private String username ;
    private ArrayList<String> chats;
    private boolean userNotExists;
    private boolean passNotMatched;
    AppScreen appScreen;
    public AppScreenCreator(){
    }
    @Override
    public void display() {
        if(userNotExists|| passNotMatched){
            showUnableToLogin();
        }else{
            /*this.appScreen = new AppScreen(username, chats);*/
            System.out.println(username);
        }
    }

    private void showUnableToLogin() {
        System.out.println("unable to login");
    }
    @Override
    public void setChatsPresenter(UserLoginOutputBoundary chatsPresenter){
        this.username = chatsPresenter.getUsername();
        this.chats = (ArrayList<String>) chatsPresenter.getChats();
        this.userNotExists = chatsPresenter.isNotExists();
        this.passNotMatched = chatsPresenter.isNotMatched();
    }

}
