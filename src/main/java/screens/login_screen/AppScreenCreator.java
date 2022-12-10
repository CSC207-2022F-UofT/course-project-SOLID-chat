package screens.login_screen;
import interface_adapters.appscreen.AppScreenLoader;
import interface_adapters.login_interface_adapters.UserLoginViewI;
import screens.user_registration_screen.ViewHelper;
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
        if(userNotExists){
            ViewHelper.simpleMessage("An account with this username does not exist", 300);
        } else if (passNotMatched) {
            ViewHelper.simpleMessage("Wrong username or password, please try again", 300);
        }else{
            //Could be null pointer exception if setChatsPresenter is not called before the below
            appScreenLoader.openScreen();
        }
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
