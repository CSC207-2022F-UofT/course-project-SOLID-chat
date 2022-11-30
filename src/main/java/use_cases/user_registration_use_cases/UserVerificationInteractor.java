package use_cases.user_registration_use_cases;

import data_access.Database;
import screens.login_screen.UserLoginUI;
import use_cases.user_login_use_cases.UserLoginInputBoundary;
import use_cases.user_login_use_cases.UserLoginInteractor;

import java.util.Random;

public class UserVerificationInteractor implements UserVerificationInputBoundary{
    private final Database database;
    private String username;
    private String password;
    private String email;

    private final UserVerificationOutputBoundary verificationOutputBoundary;

    private int code;

    public UserVerificationInteractor(Database database, UserVerificationOutputBoundary verificationOutputBoundary){
        this.database = database;
        this.verificationOutputBoundary = verificationOutputBoundary;
    }

    @Override
    public void verify(String type, int code) {
        System.out.println(this.code);
        if(code == this.code){
            database.createUser(this.username, this.password, this.email, "Basic");
            System.out.println("verified");
            verificationOutputBoundary.getLoginCredentials();
        }else{
            System.out.println("failure");
            verificationOutputBoundary.cannotVerify();
        }

    }

    @Override
    public void setCode(int code) {
        this.code = code;
    }

    public void setCredentials(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
