package interface_adapters.User;

public interface UserAuthenticationI {
    Boolean PasswordMatch(String attempt);
}
