import javax.swing.*;

public class UserRegistrationUI implements UserRegistrationUseCase{
    UserDatabase database = new UserDatabase();
    void GetUserCredentials(){
        JFrame RegisterFrame = new JFrame();
        JPanel RegisterPanel = new JPanel();

    }
    @Override
    public void registerUser(String username, String password, String email) {
        if(database.userExists(username, password, email)){
            System.out.println("The username or password is already in use, please try again");
        }else{
            database.createUser(username, password, email, "Basic");
            System.out.println("Your account has been created, please verify to login");
        }
    }
}
