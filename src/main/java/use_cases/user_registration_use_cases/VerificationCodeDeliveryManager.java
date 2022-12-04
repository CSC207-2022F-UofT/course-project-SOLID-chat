package use_cases.user_registration_use_cases;

import java.util.Random;
/**
 * This class is responsible for managing aspects related to verification, such as creating the verification code
 * and sending the code to the user
 * */
public class VerificationCodeDeliveryManager {
    private final int code = new Random().nextInt(134134);
    private final createMailMan mailManFactory;
    private ISendVerificationCode mailMan;
    public VerificationCodeDeliveryManager(createMailMan mailManFactory){
        this.mailManFactory = mailManFactory;
        //By default, the type will be email.
        this.setMailMan("Email");
    }
    /**
     * Sets the verification stream
     * @param type String that represents how the code is delivered
     * */
    public void setMailMan(String type){
        this.mailMan = mailManFactory.getVerificationMethod(type);
    }
    /**
     * Sends the verification code
     * @param email Represents the email
     * */
    public void deliverCode(String email){
        this.mailMan.sendVerificationCode(email, this.code);
    }
    /**
     * returns the verification code
     * */
    public int getVerCode(){
        return this.code;
    }
}
