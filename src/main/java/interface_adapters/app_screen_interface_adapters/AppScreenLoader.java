package interface_adapters.app_screen_interface_adapters;

import entities.chat.Chat;
import screens.app_screen.AppScreen;

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

    }

    /**
     * Create the screen to show to the user
     */
    @Override
    public void openScreen() {
        try {
            this.appScreen = new AppScreen(this.username, this.chats);
        } catch (Exception e) {
            throw new RuntimeException("Unexpected Interruption: cannot load screen");
        }
    }

}
