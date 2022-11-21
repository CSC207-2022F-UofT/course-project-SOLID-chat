package use_cases.user_registration_use_cases;

public interface ISendVerificationCode {
    void sendVerificationCode(String email, int code);
}
