package UseCases;

import Entities.User;

public interface UserRetriever {
    User getUser(String username);
}
