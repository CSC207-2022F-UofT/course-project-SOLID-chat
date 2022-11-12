public interface UserVerifier {
    void verify(UserDatabase database, String username);
}
