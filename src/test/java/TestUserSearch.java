import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class TestUserSearch {
    @Test
    public void TestShowUser() {
        File accounts = new File("TestUserDatabase2.csv");
        UserDatabase accountDatabase = new UserDatabase(accounts);
        UserSearchUI ui = new UserSearchUI();
        accountDatabase.createUser("parmism", "123", "parmis@gmail.com", "Basic");
        String output = "<html>Username: parmism<br>Email: parmis@gmail.com</html>";
        Assertions.assertEquals((ui.showProfile("parmism")), (output));
    }
}
