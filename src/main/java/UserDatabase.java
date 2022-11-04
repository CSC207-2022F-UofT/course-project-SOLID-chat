import java.io.*;
import java.util.Scanner;
public class UserDatabase implements UserExists, UserCreator{
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
    public void createUser(String username, String password, String email){
        User newUser = new User(username, password, email);
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
}
