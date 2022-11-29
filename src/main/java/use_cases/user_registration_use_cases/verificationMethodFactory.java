package use_cases.user_registration_use_cases;

public class verificationMethodFactory {
    public ISendVerificationCode getVerificationMethod(String type){
        return new EmailDelivery();
    }
}
