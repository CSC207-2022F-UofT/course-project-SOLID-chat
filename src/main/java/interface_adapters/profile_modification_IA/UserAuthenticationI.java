package interface_adapters.profile_modification_IA;

// allows for ChangeController to authenticate user's username and password.

public interface UserAuthenticationI {
    public Boolean PasswordMatch(String attempt);
}
