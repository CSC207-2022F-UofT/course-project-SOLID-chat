public class UserReader {
    public static String[] read(String username) {
        User user = UserDatabase.getUser(username);
        String email = user.getEmail();
        String[] out = new String[] {username, email};
//        TODO: make sure correct getUser method is used based on the new (array-based implementation) of UserDatabase
//        TODO: add name to be read potentially
        return out;

    }
}
