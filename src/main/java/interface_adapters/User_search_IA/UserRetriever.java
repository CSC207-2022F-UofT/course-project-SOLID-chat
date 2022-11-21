package interface_adapters.User_search_IA;

import interface_adapters.user_registration_interface_adapters.UserExists;
import entities.user_entities.User;
// gives access to user entity.
public interface UserRetriever extends UserExists {
    User getUser(String username);
}
