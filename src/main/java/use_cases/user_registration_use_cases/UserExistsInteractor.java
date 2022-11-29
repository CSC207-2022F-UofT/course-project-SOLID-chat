package use_cases.user_registration_use_cases;

import data_access.Database;
import screens.user_registration_screen.UserVerificationScreen;

import java.util.Random;

public class UserExistsInteractor implements UserExistsInputBoundary{
    private final int code;
    //May need to refactor this using facade design pattern since this class has too many responsibilities.
    Database database;
    UserVerificationInputBoundary verificationInputBoundary;
    UserExistsOutputBoundary existsOutputBoundary;

    private ISendVerificationCode codeMailMan;

    public UserExistsInteractor(Database database){
        this.database = database;
        this.verificationInputBoundary = new UserVerificationInteractor(database);
        this.code = new Random().nextInt(1321512);
        verificationInputBoundary.setCode(code);

    }
    @Override
    public void register(String username, String password, String email) {
        if(!database.UserExists(username, email)){
            verificationInputBoundary.setCredentials(username, password, email);
            this.existsOutputBoundary = new UserVerificationScreen(verificationInputBoundary);
            existsOutputBoundary.getVerificationCredentials();
            codeMailMan.sendVerificationCode(email, code);
        }else{
            existsOutputBoundary.presentUserExistsMessage();
        }
    }

    @Override
    public void setCodeDeliveryMethod(String type) {
        this.codeMailMan = new verificationMethodFactory().getVerificationMethod(type);
    }
}
