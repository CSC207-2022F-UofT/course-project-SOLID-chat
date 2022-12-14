package interface_adapters.appscreen;

import screens.appscreen.AppScreen;

import java.util.ArrayList;

public class AppScreenLoader implements AppScreenPresenter {

    private final String username;
    private final ArrayList<String> chats;

    /**
     * Create the app screen loader
     * @param username The username of the current user
     * @param chats A list of chat names of all the chats the given user has
     */
    public AppScreenLoader(String username, ArrayList<String> chats){
        this.username = username;
        this.chats = chats;

    }

    /**
     * Create and save the screen to show to the user
     */
    @Override
    public void openScreen() {
        try {
            AppScreen appScreen = new AppScreen(this.username, this.chats);

            // set and save the current app screen to use later for refreshing
            AppScreenStatus.setAppScreen(appScreen);

        } catch (Exception e) {
            throw new RuntimeException("Unexpected Interruption: cannot load screen");
        }
    }

}
