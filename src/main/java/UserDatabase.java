import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class UserDatabase implements UserExists, UserRetriever, UserCreator, IRetrieveList{
    File accounts;
    List<User> accountList;
    public UserDatabase(File accounts){
        this.accounts = accounts;
        this.accountList = this.getList();
    }
    @Override
    public boolean UserExists(String username, String email) {
        /*User user = null;
        try(FileInputStream fileIn = new FileInputStream(accounts);
        ObjectInputStream in = new ObjectInputStream(fileIn)){
            do{
                try{
                    user = (User)in.readObject();
                }catch(NullPointerException e){
                    user = null;
                    break;
                }
            }while(!user.getEmail().equals(email) && !user.getUsername().equals(username));
        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user != null;*/
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
        try(FileOutputStream fileOut = new FileOutputStream(accounts)){
            try(ObjectOutputStream out = new ObjectOutputStream(fileOut)){
                out.writeObject(newUser);
                this.accountList.add(newUser);
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
    public User getUser(String username) {
        User ans = null;
        for (int i = 0; i < (this.getList().size()); i++) {
            if (this.getList().get(i).getUsername().equals(username)) {
                ans = this.getList().get(i);
            }
        }
        return ans;
    }

    //Returns an ArrayList with the users that is extracted from the file, so that other objects can use this list.
    @Override
    public List<User> getList() {
        List<User> users = new ArrayList<>();
        try(FileInputStream fileIn = new FileInputStream(accounts);
            ObjectInputStream in = new ObjectInputStream(fileIn)){
            /*User user = (User) in.readObject();*/
            while(true){
                try{
                    User user = (User) in.readObject();
                    users.add(user);}
                catch(EOFException e){
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return users;
    }
}
