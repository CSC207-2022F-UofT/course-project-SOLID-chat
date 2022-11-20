package Interface_adapters;

import Entities.User_Entities.User;
import Interface_adapters.UserExists;

public interface UserRetriever extends UserExists {
    User getUser(String username);
}
