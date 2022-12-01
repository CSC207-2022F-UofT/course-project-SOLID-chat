package use_cases.user_registration_use_cases;
/**
 * Presenter interface that presents information, or gets input from user
 * */
public interface UserExistsOutputBoundary {
    /**
     * Gets the verification code from the user
     * */
    void getVerificationCredentials();
    /**
     * Presents that the user exists in the database
     * */
    void presentUserExistsMessage();
    /**
     * Gets the code from the input boundary object
     * @param code Verification code
     * */
    void getCode(int code);
    /**
     * Gets the user credentials from the input boundary object
     * @param email Email address of the user
     * @param password Password of the user
     * @param username Username of the user
     * */
    void getUserCredentials(String username, String password, String email);
}
