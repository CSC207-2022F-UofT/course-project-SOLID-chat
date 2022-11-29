import data_access.UserDatabase;
import entities.chat.Chat;
import entities.chat.GroupChat;
import entities.chat.PrivateChat;
import entities.message.TextMessage;
import entities.user_entities.BasicUser;
import screens.appscreen.AppScreen;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class TestAppScreen {

    public static void main(String[] args) {

        UserDatabase userDatabase = new UserDatabase(new File("user_accounts"));
        System.out.println(userDatabase.UserExists("amy"));

//        BasicUser james = new BasicUser("James", "password2", "email", new ArrayList<>());
//        BasicUser nasim = new BasicUser("Nasim", "password3", "email", new ArrayList<>());
//        BasicUser parmis = new BasicUser("Parmis", "password4","email", new ArrayList<>());
//        BasicUser madhav = new BasicUser("Madhav", "password5","email", new ArrayList<>());
//        BasicUser bin = new BasicUser("Bin", "password6","email", new ArrayList<>());
//        BasicUser emma = new BasicUser("Emma", "password7","email", new ArrayList<>());
//
//        GroupChat groupChat1 = new GroupChat("Group Chat 1", "gc1","Amy");
//        GroupChat groupChat2 = new GroupChat("Group Chat 2", "gc2","Amy");
//        PrivateChat privateChat1 = new PrivateChat("James", "pc1", "Amy", "James");
//        PrivateChat privateChat2 = new PrivateChat("Nasim", "pc2", "Amy", "Nasim");
//        PrivateChat privateChat3 = new PrivateChat("Parmis", "pc3", "Amy", "Parmis");
//        PrivateChat privateChat4 = new PrivateChat("Madhav", "pc4", "Amy", "Madhav");
//        PrivateChat privateChat5 = new PrivateChat("Bin", "pc5", "Amy", "Bin");
//        PrivateChat privateChat6 = new PrivateChat("Emma", "pc6", "Amy", "Emma");

//        ArrayList<Chat> myChats = new ArrayList<>();
//        myChats.add(groupChat2);
//        myChats.add(groupChat1);
//        myChats.add(privateChat6);
//        myChats.add(privateChat5);
//        myChats.add(privateChat4);
//        myChats.add(privateChat3);
//        myChats.add(privateChat2);
//        //myChats.add(privateChat1);
//        privateChat2.addToConvHist(new TextMessage("amy", "Hi", LocalDateTime.now(), "1"));
//        AppScreen appScreen = new AppScreen("amy", myChats);
//
//        privateChat1.addToConvHist(new TextMessage("amy", "Hi", LocalDateTime.now(), "2"));
//        appScreen.addNewChat(privateChat1);
//        appScreen.updateScreen("gc1");


//        for (Chat chat: userDatabase.getUserChats("amy")){
//            System.out.println(chat.getName());
//        }
//
//        System.out.println(userDatabase.getUser("amy").getChats());




    }
}
