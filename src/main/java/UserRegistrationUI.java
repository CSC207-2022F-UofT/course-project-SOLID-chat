import javax.swing.*;

public class UserRegistrationUI implements UserRegistrationUseCase{
    private UserDatabase database;

    public UserRegistrationUI(UserDatabase database){
        this.database = database;
    }
    void GetUserCredentials(){
        JFrame RegisterFrame = new JFrame();
        RegisterFrame.setSize(1000, 1000);
        RegisterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel RegisterPanel = new JPanel();
        RegisterFrame.add(RegisterPanel);

        //The textbox for entering the Username
        RegisterPanel.setLayout(null);
        JLabel usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(10, 25, 100, 25);

        JTextField usernameText = new JTextField(20);
        usernameText.setBounds(100, 20, 165, 25);
        RegisterPanel.add(usernameText);

        //The textbox for entering the password
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(100, 50, 165, 25);
        RegisterPanel.add(passwordText);

        //The textbox for entering the email
        JLabel

        RegisterFrame.setVisible(true);
    }
    @Override
    public void registerUser(String username, String password, String email) {
        if(database.UserExists(username, email)){
            System.out.println("The username or password is already in use, please try again");
        }else{
            database.createUser(username, password, email, "Basic");
            System.out.println("Your account has been created, please verify to login");
        }
    }

    public static void main(String[] args){
        UserDatabase testDB = new UserDatabase();
        UserRegistrationUI testUI = new UserRegistrationUI(testDB);
        testUI.GetUserCredentials();
    }
}
