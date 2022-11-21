import data_access.UserDatabase;
import org.junit.jupiter.api.Assertions;
import screens.profile_update_screen.UserModificationUI;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestUserChange {
    @Test
    public void correctChange() {
        UserDatabase db = new UserDatabase();
        db.createUser("parmism", "123", "parmis@gmail.com", "Basic");
        UserModificationUI ui = new UserModificationUI();
        ui.reportChange("parmism", "123", "Email", "parmis@yahoo.com");
        UserDatabase db2 = new UserDatabase();
        String actual = db2.getUser("parmism").getEmail();
        Assertions.assertEquals("parmis@yahoo.com", actual);
    }
}
