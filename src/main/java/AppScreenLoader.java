import testerEntities.Chat;
import testerEntities.User;
import java.util.ArrayList;

public class AppScreenLoader implements LoginSuccess {

    private final String username;
    private final ArrayList<Chat> chats;
    public AppScreen appScreen;

    /**
     * Create the appscreen loader (and store its user and chat information)
     * @param username The username of the current user
     * @param chats The chats that the user is in
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
     * Open an app screen for the user to see containing all their chats
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
