package use_cases.user_login_use_cases;

import data_access.Database;
import entities.user_entities.User;

public class UserLoginPresenter {
    private String username;
    private String password;
    private User user;
    Database database;
    public UserLoginPresenter(Database database){
        this.database = database;
    }

    public void tryLogin() {
        try{
            //TODO: issues here with serialization, and dependency inversion
            user = database.getUser(username);
            if(user.PasswordMatch(this.password)){
                user.login();
            }else{
                System.out.println("the password or username is incorrect");
            }
        }catch(NullPointerException e){
            //TODO: implement login output boundary
            System.out.println("An account with these credentials do not exist");
        }

    }

    public void setLoginCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
