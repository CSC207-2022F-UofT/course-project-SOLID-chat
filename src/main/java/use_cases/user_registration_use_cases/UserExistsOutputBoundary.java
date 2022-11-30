package use_cases.user_registration_use_cases;

public interface UserExistsOutputBoundary {
    void getVerificationCredentials();
    void presentUserExistsMessage();
    void getCode(int code);
    void getUserCredentials(String username, String password, String email);
}
