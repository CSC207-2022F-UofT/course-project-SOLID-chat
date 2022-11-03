import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class UserDatabase implements UserRegPresenter, UserCreator{
    @Override
    public boolean UserExists() {
        File accounts = new File("UserAccounts.csv");

        return false;
    }

    // Creates a new user with a username and password, and an email address
    // The order is username, password, email address, verification status, status
    //
    @Override
    public void createUser(String username, String password, String email) {
            File accounts = new File("UserAccounts.csv");
            try(PrintWriter out = new PrintWriter(accounts)){
                out.println(username + "," + password + "," + email + "," + "no" + "offline");
                out.flush();
            }catch (FileNotFoundException e){
                System.out.println("Error creating/writing to file");
                e.printStackTrace();
            };
    }
}
