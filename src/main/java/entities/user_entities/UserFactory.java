package entities.user_entities;
import java.util.ArrayList;

public class UserFactory {
    /*
    Following the factory design pattern, just in case in the future we decide to add various different types of Users,
    with different privileges
    */
    public static User BirthUser(String Username, String Password, String Email, String type){
        return new BasicUser(Username, Password, Email, new ArrayList<>());
    }
}
