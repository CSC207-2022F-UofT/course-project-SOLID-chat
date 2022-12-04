import data_access.UserDatabase;
import entities.chat.Chat;
import entities.user_entities.User;
import interface_adapters.chat.UserChats;

import java.io.File;

public class TestAppScreen {

    public static void main(String[] args) {

        UserDatabase userDatabase = new UserDatabase(new File("user_accounts"));
        System.out.println(userDatabase.UserExists("amy"));
        User amy = userDatabase.getUser("amy");
        amy.login();


        for (Chat chat: userDatabase.getUserChats("amy")){
            System.out.println(chat.getName());
        }
        UserChats userChats = new UserChats("amy");
        //userChats.getUserChats("amy").get(1);
        int i = 0;
        for (Chat chat: userChats.getUserChats("amy")){
            System.out.println(i);
            i++;
        }
        System.out.println(i);




    }
}
