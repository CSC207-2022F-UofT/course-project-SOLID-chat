package use_cases.user_registration_use_cases;
//This is an output boundary object for the user registration use case.
public interface ISendVerificationCode {
    void sendVerificationCode(String email, int code);
}
