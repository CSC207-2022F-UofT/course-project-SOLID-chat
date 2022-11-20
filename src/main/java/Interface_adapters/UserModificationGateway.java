package Interface_adapters;

import Entities.User_Entities.User;

// allows for the serialized data_access.UserDatabase to update when changes occur to user attributes.
public interface UserModificationGateway {
    public void modifyUser(String oldUsername, User modified);
}

