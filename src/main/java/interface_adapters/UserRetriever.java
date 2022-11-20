package interface_adapters;

import Entities.user_entities.User;
import interface_adapters.user_registration_interface_adapters.UserExists;

public interface UserRetriever extends UserExists {
    User getUser(String username);
}
