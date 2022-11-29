package use_cases.user_login_use_cases;

import data_access.Database;
import entities.user_entities.User;

public class UserLoginInteractor implements UserLoginInputBoundary {
    private String username;
    private String password;
    private User user;
    Database database;
    public UserLoginInteractor(Database database){
        this.database = database;
    }

    @Override
    public void tryLogin() {
        //TODO: complete this method and UserLoginOutputBoundary
        try{
            user = database.getUser(username);
            if(user.PasswordMatch(this.password)){
                user.login();
            }else{
                System.out.println("the password or username is incorrect");
            }
        }catch(NullPointerException e){
            System.out.println("An account with these credentials do not exist");
        }

    }

    @Override
    public void setLoginCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
