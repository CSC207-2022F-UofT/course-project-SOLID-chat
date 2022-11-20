package PresentersControllersGateways;

import Entities.User;

// allows for the serialized Screens.UserDatabase to update when changes occur to user attributes.
public interface UserModificationGateway {
    public void modifyUser(String oldUsername, User modified);
}

