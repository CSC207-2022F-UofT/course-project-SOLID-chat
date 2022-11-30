package use_cases.user_registration_use_cases;

import use_cases.user_login_use_cases.UserLoginInputBoundary;

public interface UserVerificationOutputBoundary {
    void getLoginCredentials();
    void cannotVerify();

    void setInputBoundary(UserLoginInputBoundary loginInteractor2);
}
