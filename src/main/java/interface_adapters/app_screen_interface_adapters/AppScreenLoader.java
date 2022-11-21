package interface_adapters.app_screen_interface_adapters;

import screens.app_screen.AppScreen;
import entities.chat.Chat;
import use_cases.app_screen_use_case.AppScreenPresenter;

import java.util.ArrayList;

public class AppScreenLoader implements AppScreenPresenter {

    private final String username;
    private final ArrayList<Chat> chats;
    public AppScreen appScreen;

    /**
     * Create the app screen loader (and store its user and chat information)
     * @param username The username of the current user
     */
    public AppScreenLoader(String username, ArrayList<Chat> chats){
        this.username = username;
        this.chats = chats;
        try {
            openScreen();
        } catch (Exception e) {
            throw new RuntimeException("Unexpected Interruption: cannot load screen");
        }

    }

    /**
     * Create the screen to show to the user
     */
    @Override
    public void openScreen() {
        this.appScreen = new AppScreen(this.username, this.chats);
    }

}
