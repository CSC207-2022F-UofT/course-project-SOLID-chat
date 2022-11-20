import Profile_screen.UserSearchUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUserSearch {
    @Test
    public void TestShowUser() {
        UserDatabase db = new UserDatabase();
        UserSearchUI ui = new UserSearchUI();
        db.createUser("parmism", "123", "parmis@gmail.com", "Basic");
        String output = "<html>Username: parmism<br>Email: parmis@gmail.com</html>";
        Assertions.assertEquals((ui.showProfile("parmism")), (output));
    }
}
