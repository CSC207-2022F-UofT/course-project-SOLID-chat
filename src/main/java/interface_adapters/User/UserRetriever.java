package interface_adapters.User;

import entities.userEntities.User;

public interface UserRetriever {
    User getUser(String username);
}
