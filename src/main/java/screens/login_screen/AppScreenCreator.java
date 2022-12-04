package screens.login_screen;
import interface_adapters.appscreen.AppScreenLoader;
import interface_adapters.login_interface_adapters.UserLoginViewI;
import use_cases.user_login_use_cases.UserLoginOutputBoundary;

import java.util.ArrayList;
/**
 * Responsible for creating the view once User presses login
 * **/
public class AppScreenCreator implements UserLoginViewI {
    private boolean userNotExists;
    private boolean passNotMatched;
    AppScreenLoader appScreenLoader;
    public AppScreenCreator(){
    }
    /**
     * Opens the chats of the user
     * **/
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
    /**
     * Shows a frame that displays a message
     * **/
    private void showUnableToLogin() {
        System.out.println("unable to login");
    }
    /**
     * Gets the info from the presenter in order to output info into the screen
     * **/
    @Override
    public void setChatsPresenter(UserLoginOutputBoundary chatsPresenter){
        String username = chatsPresenter.getUsername();
        ArrayList<String> chats = (ArrayList<String>) chatsPresenter.getChats();
        this.userNotExists = chatsPresenter.isNotExists();
        this.passNotMatched = chatsPresenter.isNotMatched();
        appScreenLoader = new AppScreenLoader(username, chats);
    }

}
