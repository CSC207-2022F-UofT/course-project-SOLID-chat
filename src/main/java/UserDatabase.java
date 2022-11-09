import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class UserDatabase implements UserExists, UserRetriever, UserCreator, IRetrieveList{
    File accounts;
    public UserDatabase(File accounts){
        this.accounts = accounts;
    }
    @Override
    public boolean UserExists(String username, String email) {
        User user = null;
        try(FileInputStream fileIn = new FileInputStream(accounts);
        ObjectInputStream in = new ObjectInputStream(fileIn)){
            do{
                try{
                    user = (User)in.readObject();
                }catch(NullPointerException e){
                    break;
                }
            }while(!user.getEmail().equals(email) && !user.getUsername().equals(username));
        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user != null;
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
        User user = null;
        try(FileInputStream fileIn = new FileInputStream(accounts);
            ObjectInputStream in = new ObjectInputStream(fileIn)){
            do{
                try{
                    user = (User)in.readObject();
                }catch(NullPointerException e){
                    break;
                }
            }while(!user.getUsername().equals(username));
        }catch(IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    //Returns an ArrayList with the users that is extracted from the file, so that other objects can use this list.
    @Override
    public List<User> getList() {
        List<User> users = new ArrayList<>();
        try(FileInputStream fileIn = new FileInputStream(accounts);
            ObjectInputStream in = new ObjectInputStream(fileIn)){
            User user = (User) in.readObject();
            while(user != null){
                users.add(user);
                user = (User)in.readObject();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return users;
    }
}
