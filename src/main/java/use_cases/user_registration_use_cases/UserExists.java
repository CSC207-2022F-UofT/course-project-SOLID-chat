
package use_cases.user_registration_use_cases;
public interface UserExists {
    /**
     * Method that checks if a user exists in the database
     * @param email Email address of the user
     * @param username Username of the user
     * */
    boolean UserExists(String username, String email);
    /**
     * Method that checks if a user exists in the database
     * @param username Username of the user
     * */
    boolean UserExists(String username);
}
