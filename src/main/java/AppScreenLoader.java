import testerEntities.*;
import java.io.File;
import java.util.ArrayList;

public class AppScreenLoader implements LoginSuccess {

    private final String username;
    private final ArrayList<Chat> chats;
    public AppScreen appScreen;

    /**
     * Create the app screen loader (and store its user and chat information)
     * @param username The username of the current user
     */
    public AppScreenLoader(String username, File accounts){
        this.username = username;
        UserChatGateway userChatsGateway = new UserChatGateway(accounts);
        this.chats = userChatsGateway.getChats(username);
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
