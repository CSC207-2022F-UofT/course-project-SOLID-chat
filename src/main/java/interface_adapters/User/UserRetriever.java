package interface_adapters.User;

import entities.user_entities.User;

public interface UserRetriever {
    User getUser(String username);
}
