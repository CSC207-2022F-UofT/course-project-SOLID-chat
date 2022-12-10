package use_cases.user_registration_use_cases;
/**
 * Interface that has a method which represents the sending of the verification code to the user
 * */
public interface ISendVerificationCode {
    void sendVerificationCode(String email, int code);
}
