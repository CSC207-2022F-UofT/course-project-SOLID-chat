import data_access.UserDatabase;
import entities.user_entities.User;

import java.io.File;
import java.util.List;

// this is just for testing the UI
public class TestAppScreenUI {

    public static void main(String[] args) {

        UserDatabase userDatabase = new UserDatabase(new File("tester_file"));

        List<User> users = userDatabase.getList();
        for (User user: users){
              System.out.println(user.getUsername());
        }
        System.out.println(users.size());

        System.out.println(userDatabase.UserExists("amy"));
//
//
//        for (Chat chat: userDatabase.getUserChats("amy")){
//            System.out.println(chat.getName());
//        }
//        UserChats userChats = new UserChats("amy");
//        //userChats.getUserChats("amy").get(1);
//        int i = 0;
//        for (Chat chat: userChats.getUserChats("amy")){
//            System.out.println(i);
//            i++;
//        }
//        System.out.println(i);






    }
}
