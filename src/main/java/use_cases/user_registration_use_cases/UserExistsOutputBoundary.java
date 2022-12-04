package use_cases.user_registration_use_cases;

public interface UserExistsOutputBoundary {
    void getVerificationCredentials();
    void presentUserExistsMessage();
}
