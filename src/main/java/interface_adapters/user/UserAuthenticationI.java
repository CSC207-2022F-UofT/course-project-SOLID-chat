package interface_adapters.user;

public interface UserAuthenticationI {
    Boolean PasswordMatch(String attempt);
}
