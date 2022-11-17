// allows for the serialized UserDatabase to update when changes occur to user attributes.
public interface UserModificationGateway {
    public void modifyUser(String oldUsername, User modified);
}

