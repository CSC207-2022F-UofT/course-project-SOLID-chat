import testerEntities.*;
import java.io.File;
import java.util.ArrayList;

public class UserChatGateway {
    private final UserDataBase userDataBase;

    /**
     * Create the gateway between the user database and the screen loader to get the chats
     * @param userAccounts The file containing user information
     */
    public UserChatGateway(File userAccounts){
        this.userDataBase = new UserDataBase(userAccounts);
    }

    /**
     * Get the chats of a user
     * @param username The username of the user
     * @return An arraylist of chats that the user has
     */
    public ArrayList<Chat> getChats(String username){
        return this.userDataBase.getUserChats(username);
    }


}
