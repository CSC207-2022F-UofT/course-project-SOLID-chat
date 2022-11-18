package appscreen;

import testerEntities.*;
import java.util.ArrayList;

public class AppScreenLoader implements LoginSuccess {

    private final String username;
    private final ArrayList<Chat> chats;
    public AppScreen appScreen;

    /**
     * Create the app screen loader (and store its user and chat information)
     * @param username The username of the current user
     * @param userDataBase User information
     */
    public AppScreenLoader(String username, UserDataBase userDataBase){
        this.username = username;
        this.chats = userDataBase.getUserChats(username);
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

    /**
     * @return The username of the current user
     */
    public String getUsername(){
        return this.username;
    }

    /**
     * @return A list of chats that the user is in
     */
    public ArrayList<Chat> getChats(){
        return new ArrayList<>(this.chats);
    }
}
