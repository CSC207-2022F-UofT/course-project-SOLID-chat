package use_cases.user_registration_use_cases;

import data_access.Database;

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
    /**
     * Compares code with this.code, if they match, the program will proceed to ask for login credentials
     * Else, it will present a message that verification is not possible
     * @param code code inputted by the user
     * */
    @Override
    public void verify(int code) {
        System.out.println(this.code);
        if(code == this.code){
            database.createUser(this.username, this.password, this.email, "Basic");
            verificationOutputBoundary.getLoginCredentials();
        }else{
            verificationOutputBoundary.cannotVerify();
        }

    }
    /**
     * Sets the code to compare for verification
     * @param code verification code*/
    @Override
    public void setCode(int code) {
        this.code = code;
    }
    /**
     * Sets the user credentials for this object
     * */
    public void setCredentials(String username, String password, String email){
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
