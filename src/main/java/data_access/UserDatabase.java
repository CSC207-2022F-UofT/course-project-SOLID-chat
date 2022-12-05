package data_access;

import entities.chat.Chat;
import interface_adapters.user_search_IA.IRetrieveList;
import entities.user_entities.User;
import interface_adapters.profile_modification_IA.UserModificationGateway;
import entities.user_entities.UserFactory;
import interface_adapters.chat.UserChatGateway;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class UserDatabase implements Database, IRetrieveList, UserModificationGateway, UserChatGateway {
    File accounts;
    List<User> accountList;
    public UserDatabase(){
        this.accounts = new File("user_accounts");
        if(!accounts.exists()){
            try {
                accounts.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        this.accountList = this.getList();
    }
    public UserDatabase(File accounts){
        if(!accounts.exists()){
            try {
                accounts.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        this.accounts = accounts;
        this.accountList = this.getList();
    }
    @Override
    public boolean UserExists(String username, String email) {
        for(User user: this.accountList){
            if(user.getUsername().equals(username) || user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if a user with given Username exists.
     */
    //TODO: this method can be be simplified to "return UserExists(username, "");"
    @Override
    public boolean UserExists(String username) {
        for(User user: this.accountList){
            if(user.getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }

    // Creates a new user with a username and password, and an email address
    // The order is username, password, email address, verification status, status
    //
    @Override
    public void createUser(String username, String password, String email, String type){
        User newUser = UserFactory.BirthUser(username, password, email, type);
        addUserToFile(newUser);
    }

    private void addUserToFile(User newUser) {
        this.accountList.add(newUser);
        try(FileOutputStream fileOut = new FileOutputStream(accounts)){
            try(ObjectOutputStream out = new ObjectOutputStream(fileOut)){
                out.writeObject(this.accountList);
                out.close();
                fileOut.close();
            }catch(Exception e){
                System.out.println("Error");
            }
        }catch(Exception e){
            System.out.println("Error");
        }
    }

    /**
     * getUser retrieves a User object based on passed username.
     */
    @Override
//  To be edited to get user from the array format rather than the serialized format.
    //TODO: for loop can be replaced with enhanced for loop
    public User getUser(String username) {
        User ans = null;
        for (User user : this.accountList) {
            if (user.getUsername().equals(username)) {
                ans = user;
            }
        }
        return ans;
    }

    //Returns an ArrayList with the users that is extracted from the file, so that other objects can use this list.
    @Override
    public List<User> getList() {
        List<User> users = new ArrayList<>();
        try(FileInputStream fileIn = new FileInputStream(accounts);
            ObjectInputStream in = new ObjectInputStream(fileIn)) {

            users = (ArrayList<User>) in.readObject();
            return users;
        //TODO: this is not a good use of exceptions, but I could not find any other way to do it.
        }catch(EOFException e){
            return users;
            } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * modifyUser updates the serialized database with modified user information.
     * TODO: There is a code smell here, since it contains duplicated lines from createUser, this can be fixed by first
     *  removing the user, then calling this.createUser
     */
    @Override
    public void modifyUser(String oldUsername, User modified){
//        swap in modified user to accountList
        this.accountList.remove(this.getUser(oldUsername));
        addUserToFile(modified);
    }

    @Override
    public ArrayList<Chat> getUserChats(String username) {
        for (User user: accountList){
            if(user.getUsername().equals(username)){
                return user.getChats();
            }
        }
        throw new RuntimeException("Invalid username");
    }

    // Below two methods are used by conversation history-related interactors
    // (Commented as objects are not found)
//    /**
//     * Pushes a new message to a chat's conversation history (in memory not persisting storage)
//     * @param dsRequestModel input data containing user ID, chat ID, message content
//     */
//    public void saveMessage(MsgSenderDsRequestModel dsRequestModel) {
//        String userID = dsRequestModel.getUserID();
//        String chatID = dsRequestModel.getChatID();
//        Message message = dsRequestModel.getMessage();
//
//        // Find chat under specified Entities.User_Entities.User
//        Chat chat = this.getUser(userID).getChat(chatID);
//
//        chat.addMessage(message);
//    }
//
//    /**
//     * Gets a chat's conversation history (from memory not persisting storage)
//     * @param dsRequestModel input data containing user ID, chat ID
//     * @return a chat's conversation history
//     */
//    public ArrayList<Message> getConversationHistory(ConvHistDsRequestModel dsRequestModel) {
//        String userID = dsRequestModel.getUserID();
//        String chatID = dsRequestModel.getChatID();
//
//        // Find chat under specified Entities.User_Entities.User
//        Chat chat = this.getUser(userID).getChat(chatID);
//
//        return Chat.getConversationHistory();
//    }
}
