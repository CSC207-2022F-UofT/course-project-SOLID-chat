package use_cases.user_registration_use_cases;

import data_access.Database;

import java.util.Random;

public class UserExistsInteractor implements UserExistsInputBoundary{
    private final createMailMan mailManFactory;
    //May need to refactor this using facade design pattern since this class has too many responsibilities.
    Database database;
    UserExistsOutputBoundary existsOutputBoundary;

    private ISendVerificationCode codeMailMan;

    public UserExistsInteractor(Database database, UserExistsOutputBoundary existsOutputBoundary, createMailMan mailMan){
        this.database = database;
        this.existsOutputBoundary = existsOutputBoundary;
        this.mailManFactory = mailMan;
    }
    @Override
    public void register(String username, String password, String email) {
        if(!database.UserExists(username, email)){
            int code = new Random().nextInt(12312341);
            existsOutputBoundary.getCode(code);
            existsOutputBoundary.getUserCredentials(username, password, email);
            existsOutputBoundary.getVerificationCredentials();
            codeMailMan.sendVerificationCode(email, code);
        }else{
            existsOutputBoundary.presentUserExistsMessage();
        }
    }

    @Override
    public void setCodeDeliveryMethod(String type) {
        this.codeMailMan = mailManFactory.getVerificationMethod(type);
    }

    @Override
    public void setOutputBoundary(UserExistsOutputBoundary existsOutputBoundary) {
        this.existsOutputBoundary = existsOutputBoundary;
    }
}
