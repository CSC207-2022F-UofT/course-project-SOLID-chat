import org.junit.jupiter.api.Assertions;

import java.io.File;

public class TestUserChange {
    public void correctChange() {
        File accounts = new File("TestUserDatabase2.csv");
        UserDatabase accountDatabase = new UserDatabase(accounts);
        accountDatabase.createUser("parmism", "123", "parmis@gmail.com", "Basic");
        UserModificationUI ui = new UserModificationUI();
        ui.reportChange("parmism", "123", "Password", "456");
        String actual = accountDatabase.getUser("parmism").getPassword();
        Assertions.assertEquals("456", actual);
    }
}
