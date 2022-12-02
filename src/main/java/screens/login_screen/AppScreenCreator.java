package screens.login_screen;
import interface_adapters.appscreen.AppScreenLoader;
import interface_adapters.login_interface_adapters.UserChatsPresenter;
import interface_adapters.login_interface_adapters.UserLoginViewI;
import screens.appscreen.AppScreen;
import use_cases.user_login_use_cases.UserLoginOutputBoundary;

import java.util.ArrayList;

public class AppScreenCreator implements UserLoginViewI {
    private boolean userNotExists;
    private boolean passNotMatched;
    AppScreenLoader appScreenLoader;
    public AppScreenCreator(){
    }
    @Override
    public void display() {
        if(userNotExists|| passNotMatched){
            showUnableToLogin();
        }else{
            /*this.appScreen = new AppScreen(username, chats);*/
            //Could be null pointer exception if setChatsPresenter is not called before the below
            appScreenLoader.openScreen();
        }
    }

    private void showUnableToLogin() {
        System.out.println("unable to login");
    }
    @Override
    public void setChatsPresenter(UserLoginOutputBoundary chatsPresenter){
        String username = chatsPresenter.getUsername();
        ArrayList<String> chats = (ArrayList<String>) chatsPresenter.getChats();
        this.userNotExists = chatsPresenter.isNotExists();
        this.passNotMatched = chatsPresenter.isNotMatched();
        appScreenLoader = new AppScreenLoader(username, chats);
    }

}
