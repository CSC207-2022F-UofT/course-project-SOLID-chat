public class UserReader {
    UserDatabase db = UserDatabase(accounts);
    public static String[] read(String username) {
        User user = db.getUser(username);
        String email = user.getEmail();
        String[] out = new String[] {username, email};
//        TODO: add name to be read potentially
        return out;

    }
}
