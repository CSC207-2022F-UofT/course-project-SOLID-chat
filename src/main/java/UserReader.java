public class UserReader {
    public static String[] read(String username) {
        User user = UserDatabase.getUser(username);
        String email = user.getEmail();
        String[] out = new String[] {username, email};
//        test without user/ user database branch using:
//        String[] out = new String[] {username, username + "@gmail.com"};
        return out;

    }
}
