package use_cases;

import Entities.User_Entities.BasicUser;
import Entities.User_Entities.User;

public class UserFactory {
    //Following the factory design pattern, just in case in the future we decide to add various different types of Users
    public static User BirthUser(String Username, String Password, String Email, String type){
        return new BasicUser(Username, Password, Email);
    }
}
