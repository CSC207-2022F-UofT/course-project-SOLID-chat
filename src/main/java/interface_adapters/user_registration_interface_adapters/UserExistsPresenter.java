package interface_adapters.user_registration_interface_adapters;

import data_access.Database;
import use_cases.user_registration_use_cases.VerificationCodeDeliveryManager;
import use_cases.user_registration_use_cases.createMailMan;

/**
 * This is the class responsible for getting processing the input given by user, and either allowing verification,
 * presenting the 'user exists' message, and sending the verification code, depending on the business logic
 * */
public class UserExistsPresenter {
    private final VerificationCodeDeliveryManager verCodeDeliveryManager;
    Database database;
    UserExistsOutputView existsOutputBoundary;

    public UserExistsPresenter(Database database, UserExistsOutputView existsOutputBoundary, createMailMan mailMan){
        this.database = database;
        this.existsOutputBoundary = existsOutputBoundary;
        //The responsibility of dealing with verification is passed onto this class
        this.verCodeDeliveryManager = new VerificationCodeDeliveryManager(mailMan);
    }
    /**
     * Proceeds to verification and sends code, or presents an error message, depending on whether a user with
     * such credentials is in the database.
     * @param username Username
     * @param email Email
     * @param password Password
     * */

    public void register(String username, String password, String email) {
        if(!database.UserExists(username, email)){
            //This may need to change if verCodeDeliveryManager decides not to create integer codes.
            int code = this.verCodeDeliveryManager.getVerCode();
            existsOutputBoundary.getCode(code);
            existsOutputBoundary.getUserCredentials(username, password, email);
            existsOutputBoundary.getVerificationCredentials();
            this.verCodeDeliveryManager.deliverCode(email);
        }else{
            existsOutputBoundary.presentUserExistsMessage();
        }
    }
    /**
     * Sets the verification stream given by the user, to send the code
     * @param type The verification stream
     * */
    public void setCodeDeliveryMethod(String type) {
        this.verCodeDeliveryManager.setMailMan(type);
    }
}
