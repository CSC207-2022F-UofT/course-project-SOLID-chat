package use_cases.user_registration_use_cases;

import data_access.Database;

/**
 * This is the class responsible for getting processing the input given by user, and either allowing verification,
 * presenting the 'user exists' message, and sending the verification code, depending on the business logic
 * */
public class UserExistsInteractor implements UserExistsInputBoundary{
    private final VerificationCodeDeliveryManager verCodeDeliveryManager;
    Database database;
    UserExistsOutputBoundary existsOutputBoundary;

    public UserExistsInteractor(Database database, UserExistsOutputBoundary existsOutputBoundary, createMailMan mailMan){
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
    @Override
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
    @Override
    public void setCodeDeliveryMethod(String type) {
        this.verCodeDeliveryManager.setMailMan(type);
    }
}
