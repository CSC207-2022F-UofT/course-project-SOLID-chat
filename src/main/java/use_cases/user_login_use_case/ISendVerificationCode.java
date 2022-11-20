package use_cases.user_login_use_case;

public interface ISendVerificationCode {
    void sendVerificationCode(String email, int code);
}
