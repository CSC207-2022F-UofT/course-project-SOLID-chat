package use_cases.user_registration_use_cases;

import java.util.Random;

public class VerificationCodeDeliveryManager {
    private final int code = new Random().nextInt(134134);
    private final createMailMan mailManFactory;
    private ISendVerificationCode mailMan;
    public VerificationCodeDeliveryManager(createMailMan mailManFactory){
        this.mailManFactory = mailManFactory;
        //By default, the type will be email.
        this.setMailMan("Email");
    }
    public void setMailMan(String type){
        this.mailMan = mailManFactory.getVerificationMethod(type);
    }
    public void deliverCode(String email){
        this.mailMan.sendVerificationCode(email, this.code);
    }
    public int getVerCode(){
        return this.code;
    }
}
