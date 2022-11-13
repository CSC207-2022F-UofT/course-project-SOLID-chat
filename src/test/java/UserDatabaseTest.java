import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 15-userdatabase-and-user
import java.util.List;

public class UserDatabaseTest {
    @Test
    public void addingFilesRightEmailAndUser(){
        File accounts = new File("TestUserDatabase2.csv");
        UserDatabase accountDatabase = new UserDatabase(accounts);
        accountDatabase.createUser("MadhavGopakumar", "123", "madhavgopan2000@gmail.com", "Basic");
        Assertions.assertTrue(accountDatabase.UserExists("MadhavGopakumar", "madhavgopan2000@gmail.com"));
    }
    @Test
    public void addingMultipleFiles(){
        File accounts = new File("TestUserDatabase2.csv");
        UserDatabase accountDatabase = new UserDatabase(accounts);
        accountDatabase.createUser("MeenakshiGopakumar", "123", "meena@gmail.com", "Basic");
        Assertions.assertTrue(accountDatabase.UserExists("MeenakshiGopakumar", "meena@gmail.com"));
    }
    @Test
    public void rightEmailWrongUser(){
        File accounts = new File("TestUserDatabase2.csv");
        UserDatabase accountDatabase = new UserDatabase(accounts);
<<<<<<< HEAD
=======
        accountDatabase.createUser("MadhavGopakumar", "123", "madhavgopan2000@gmail.com", "Basic");
>>>>>>> 15-userdatabase-and-user
        Assertions.assertTrue(accountDatabase.UserExists("MadG", "madhavgopan2000@gmail.com"));
    }
    @Test
    public void rightUserWrongEmail(){
        File accounts = new File("TestUserDatabase2.csv");
        UserDatabase accountDatabase = new UserDatabase(accounts);
        Assertions.assertTrue(accountDatabase.UserExists("MeenakshiGopakumar", "ma"));
    }
    @Test
    public void listedUsers(){
        File accounts = new File("TestUserDatabase2.csv");
        UserDatabase accountDatabase = new UserDatabase(accounts);
        accountDatabase.createUser("MeenakshiGopakumar", "123", "meena@gmail.com", "Basic");
        List<User> lst = accountDatabase.getList();
        String email = lst.get(0).getEmail();
        Assertions.assertTrue(email.equals("meena@gmail.com"));
    }

    @Test
    public void userGot() {
        File accounts = new File("TestUserDatabase2.csv");
        UserDatabase accountDatabase = new UserDatabase(accounts);
        accountDatabase.createUser("MeenakshiGopakumar", "123", "meena@gmail.com", "Basic");
        User user = accountDatabase.getUser("MeenakshiGopakumar");
        String email = user.getEmail();
        Assertions.assertTrue(email.equals("meena@gmail.com"));
    }

    }