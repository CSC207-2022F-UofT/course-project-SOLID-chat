package use_cases.user_registration_use_cases;

public interface UserVerificationInputBoundary {
    void setCode(int code);
    void setCredentials(String username, String password, String email);
    void verify(int code);
}
