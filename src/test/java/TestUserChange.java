import data_access.UserDatabase;
import org.junit.jupiter.api.Assertions;
import interface_adapters.profile_modification_IA.ChangeControllerClass;
import org.junit.jupiter.api.Test;

/**
 * Simple tests of User modification for all attribuites.
 */
public class TestUserChange {
    @Test
    public void emailChange() {
        UserDatabase db = new UserDatabase();
        ChangeControllerClass c = new ChangeControllerClass();
        db.createUser("parmism", "123", "parmis@gmail.com", "Basic");
        c.reportChange("parmism", "123", "Email", "parmis@yahoo.com");
        UserDatabase db2 = new UserDatabase();
        String actual = db2.getUser("parmism").getEmail();
        Assertions.assertEquals("parmis@yahoo.com", actual);
    }

    @Test
    public void passwordChange() {
        UserDatabase db = new UserDatabase();
        ChangeControllerClass c = new ChangeControllerClass();
        db.createUser("parmism", "123", "parmis@gmail.com", "Basic");
        c.reportChange("parmism", "123", "Password", "456");
        UserDatabase db2 = new UserDatabase();
        Assertions.assertTrue(db2.getUser("parmism").PasswordMatch("456"));
    }

    @Test
    public void oldUsernameRemoved() {
        UserDatabase db = new UserDatabase();
        ChangeControllerClass c = new ChangeControllerClass();
        db.createUser("badUsername", "123", "bad@gmail.com", "Basic");
        c.reportChange("badUsername", "123", "Username", "goodUsername");
        UserDatabase db2 = new UserDatabase();
        Assertions.assertFalse(db2.UserExists("badUsername"));
    }

    @Test
    public void newUsernameInDB() {
        UserDatabase db = new UserDatabase();
        ChangeControllerClass c = new ChangeControllerClass();
        db.createUser("badUsername", "123", "bad@gmail.com", "Basic");
        c.reportChange("badUsername", "123", "Username", "goodUsername");
        UserDatabase db2 = new UserDatabase();
        Assertions.assertTrue(db2.UserExists("goodUsername"));
    }
}
