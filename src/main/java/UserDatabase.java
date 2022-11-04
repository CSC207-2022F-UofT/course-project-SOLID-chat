import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class UserDatabase implements UserExists, UserCreator{
    File accounts;
    public UserDatabase(File accounts){
        this.accounts = accounts;
    }
    @Override
    public boolean UserExists(String username, String email) {
        try(Scanner x = new Scanner(this.accounts)){
            x.useDelimiter("\n");
            while(x.hasNext()) {
                String[] y = x.next().split(",");
                if(y[0].equals(username) || y[2].equals(email)){
                    return true;
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("Cannot find File");
        };
        return false;
    }

    // Creates a new user with a username and password, and an email address
    // The order is username, password, email address, verification status, status
    //
    @Override
    public void createUser(String username, String password, String email) {
            try(PrintWriter out = new PrintWriter(this.accounts)){
                out.println(username + "," + password + "," + email + "," + "no" + "," + "offline");
                out.flush();
            }catch (FileNotFoundException e){
                System.out.println("Error creating/writing to file");
                e.printStackTrace();
            };
    }
}
