package interface_adapters.User_search_IA;
import use_cases.user_registration_use_cases.UserExists;
import entities.user_entities.User;

/**
 * gives access to user entity.
 */
public interface UserRetriever extends UserExists {
    User getUser(String username);
}
