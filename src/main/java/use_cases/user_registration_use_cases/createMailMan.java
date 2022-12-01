package use_cases.user_registration_use_cases;
/**
 * Interface that has a method which represents the creation of objects that can send verification code*/
public interface createMailMan {
    ISendVerificationCode getVerificationMethod(String type);
}
