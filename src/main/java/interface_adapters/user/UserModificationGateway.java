package interface_adapters.user;

import entities.user_entities.User;

// allows for the serialized data_access.UserDatabase to update when changes occur to user attributes.
public interface UserModificationGateway {
    public void modifyUser(String oldUsername, User modified);
}

