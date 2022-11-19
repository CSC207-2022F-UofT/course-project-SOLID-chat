import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class UserDatabase implements UserExists, UserRetriever, UserCreator, IRetrieveList, UserModificationGateway,
ConvHistGateway, MsgSenderGateway {
    File accounts;
    List<User> accountList;
    public UserDatabase(){
        this.accounts = new File("TestUserDatabase3.csv");
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

    @Override
//  To be edited to get user from the array format rather than the serialized format.
    public User getUser(String username) {
        User ans = null;
        for (int i = 0; i < (this.accountList.size()); i++) {
            if (this.accountList.get(i).getUsername().equals(username)) {
                ans = this.accountList.get(i);
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
            /*
            while(true){
                try{
                    User user = (User) in.readObject();
                    users.add(user);}
                catch(EOFException e){
                    break;
                }*/
            return users;
        }catch(EOFException e){
            return users;
            } catch (IOException | ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void modifyUser(String oldUsername, User modified){
//        swap in modified user to accountList
        this.accountList.remove(this.getUser(oldUsername));
        this.accountList.add(modified);

//        overwrite the serialized file
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
//        // Find chat under specified User
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
//        // Find chat under specified User
//        Chat chat = this.getUser(userID).getChat(chatID);
//
//        return Chat.getConversationHistory();
//    }
}
