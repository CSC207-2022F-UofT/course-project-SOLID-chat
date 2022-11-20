package Interface_adapters;

import entities.user_entities.User;

public interface UserRetriever extends UserExists {
    User getUser(String username);
}
