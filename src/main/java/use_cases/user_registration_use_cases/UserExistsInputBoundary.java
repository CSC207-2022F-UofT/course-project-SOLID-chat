package use_cases.user_registration_use_cases;

public interface UserExistsInputBoundary {

    void register(String username, String password, String email);
    void setCodeDeliveryMethod(String type);
}
