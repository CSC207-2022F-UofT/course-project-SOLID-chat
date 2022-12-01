import data_access.UserDatabase;
import interface_adapters.user_search_IA.UserPresenterClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Simple test ofile display feature.
 */
public class TestUserSearch {
    @Test
    public void TestShowUser() {
        UserDatabase db = new UserDatabase();
        UserPresenterClass p = new UserPresenterClass();
        db.createUser("parmism", "123", "parmis@gmail.com", "Basic");
        String output = "<html>Username: parmism<br>Email: parmis@gmail.com</html>";
        Assertions.assertEquals((p.showProfile("parmism")), (output));
    }
}
