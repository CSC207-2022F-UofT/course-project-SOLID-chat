import java.io.*;
import java.util.Scanner;
public class UserDatabase implements UserExists, UserRetriever, UserCreator{
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
//    TODO: create userExists that takes 1 parameter: username.

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
}
