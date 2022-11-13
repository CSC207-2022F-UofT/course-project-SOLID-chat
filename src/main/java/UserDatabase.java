import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class UserDatabase implements UserExists, UserRetriever, UserCreator, IRetrieveList{
    File accounts;
<<<<<<< HEAD
    public UserDatabase(){
        this.accounts = new File("UserAccounts.csv");
    }
    public UserDatabase(File accounts){
        this.accounts = accounts;
    }
    @Override
    public boolean UserExists(String username, String email) {
        User user = null;
=======
    List<User> accountList;
    public UserDatabase(File accounts){
        this.accounts = accounts;
        this.accountList = this.getList();
    }
    @Override
    public boolean UserExists(String username, String email) {
        /*User user = null;
>>>>>>> 15-userdatabase-and-user
        try(FileInputStream fileIn = new FileInputStream(accounts);
        ObjectInputStream in = new ObjectInputStream(fileIn)){
            do{
                try{
                    user = (User)in.readObject();
                }catch(NullPointerException e){
<<<<<<< HEAD
=======
                    user = null;
>>>>>>> 15-userdatabase-and-user
                    break;
                }
            }while(!user.getEmail().equals(email) && !user.getUsername().equals(username));
        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
<<<<<<< HEAD
        return user != null;
=======
        return user != null;*/
        for(User user: this.accountList){
            if(user.getUsername().equals(username) || user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
>>>>>>> 15-userdatabase-and-user
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
<<<<<<< HEAD
=======
                this.accountList.add(newUser);
>>>>>>> 15-userdatabase-and-user
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
<<<<<<< HEAD
            User user = (User) in.readObject();
            while(user != null){
                users.add(user);
                user = (User)in.readObject();
=======
            /*User user = (User) in.readObject();*/
            while(true){
                try{
                    User user = (User) in.readObject();
                    users.add(user);}
                catch(EOFException e){
                    break;
                }
>>>>>>> 15-userdatabase-and-user
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return users;
    }
}
