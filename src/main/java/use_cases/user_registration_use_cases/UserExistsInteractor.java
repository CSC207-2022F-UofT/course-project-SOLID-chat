package use_cases.user_registration_use_cases;

import data_access.Database;

import java.util.Random;

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
    @Override
    public void register(String username, String password, String email) {
        if(!database.UserExists(username, email)){
            int code = this.verCodeDeliveryManager.getVerCode();
            existsOutputBoundary.getCode(code);
            existsOutputBoundary.getUserCredentials(username, password, email);
            existsOutputBoundary.getVerificationCredentials();
            this.verCodeDeliveryManager.deliverCode(email);
        }else{
            existsOutputBoundary.presentUserExistsMessage();
        }
    }

    @Override
    public void setCodeDeliveryMethod(String type) {
        this.verCodeDeliveryManager.setMailMan(type);
    }

    @Override
    public void setOutputBoundary(UserExistsOutputBoundary existsOutputBoundary) {
        this.existsOutputBoundary = existsOutputBoundary;
    }
}
