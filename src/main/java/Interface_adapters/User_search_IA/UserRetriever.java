package Interface_adapters.User_search_IA;

import Interface_adapters.user_registration_interface_adapter.UserExists;
import entities.user_entities.User;

public interface UserRetriever extends UserExists {
    User getUser(String username);
}
