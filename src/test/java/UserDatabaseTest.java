import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;

public class UserDatabaseTest {
    @Test
    public void addingFilesRightEmailAndUser(){
        File accounts = new File("TestUserDatabase2.csv");
        UserDatabase accountDatabase = new UserDatabase(accounts);
        accountDatabase.createUser("MadhavGopakumar", "123", "madhavgopan2000@gmail.com");
        Assertions.assertTrue(accountDatabase.UserExists("MadhavGopakumar", "madhavgopan2000@gmail.com"));
    }
    @Test
    public void addingMultipleFiles(){
        File accounts = new File("TestUserDatabase2.csv");
        UserDatabase accountDatabase = new UserDatabase(accounts);
        accountDatabase.createUser("MeenakshiGopakumar", "123", "meena@gmail.com");
        Assertions.assertTrue(accountDatabase.UserExists("MeenakshiGopakumar", "meena@gmail.com"));
    }
    @Test
    public void rightEmailWrongUser(){
        File accounts = new File("TestUserDatabase2.csv");
        UserDatabase accountDatabase = new UserDatabase(accounts);
        Assertions.assertTrue(accountDatabase.UserExists("MadG", "madhavgopan2000@gmail.com"));
    }
    @Test
    public void rightUserWrongEmail(){
        File accounts = new File("TestUserDatabase2.csv");
        UserDatabase accountDatabase = new UserDatabase(accounts);
        Assertions.assertTrue(accountDatabase.UserExists("MeenakshiGopakumar", "ma"));
    }
    }