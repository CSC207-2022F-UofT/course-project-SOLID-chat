
import java.util.ArrayList;

import appscreen.AppScreen;
import testerEntities.*;

public class TestAppScreen {

    public static void main(String[] args) {

        User amy = new User("Amy", "password1", "email");
        User james = new User("James", "password2", "email");
        User nasim = new User("Nasim", "password3", "email");
        User parmis = new User("Parmis", "password4","email");
        User madhav = new User("Madhav", "password5","email");
        User bin = new User("Bin", "password6","email");
        User emma = new User("Emma", "password7","email");

        GroupChat groupChat1 = new GroupChat("SOLID-CHAT", "gc1","Amy");
        GroupChat groupChat2 = new GroupChat("Chat People", "gc2","Amy");
        PrivateChat privateChat1 = new PrivateChat("James", "pc1", "Amy", "James");
        PrivateChat privateChat2 = new PrivateChat("Nasim", "pc2", "Amy", "Nasim");
        PrivateChat privateChat3 = new PrivateChat("Parmis", "pc3", "Amy", "Parmis");
        PrivateChat privateChat4 = new PrivateChat("Madhav", "pc4", "Amy", "Madhav");
        PrivateChat privateChat5 = new PrivateChat("Bin", "pc5", "Amy", "Bin");
        PrivateChat privateChat6 = new PrivateChat("Emma", "pc6", "Amy", "Emma");

        ArrayList<Chat> myChats = new ArrayList<>();
        myChats.add(groupChat2);
        myChats.add(groupChat1);
        myChats.add(privateChat6);
        myChats.add(privateChat5);
        myChats.add(privateChat4);
        myChats.add(privateChat3);
        myChats.add(privateChat2);
        myChats.add(privateChat1);
        AppScreen appScreen = new AppScreen("Amy", myChats);
//        appscreen.AppScreenLoader appScreenLoader = new appscreen.AppScreenLoader("amy", myChats);
//        appScreenLoader.openScreen();
//        appScreenLoader.appScreen.updateScreen(privateChat2);
        appScreen.updateScreen(groupChat2);
        //appScreen.update(groupChat1);
        //myChats.add(privateChat1);
        //appScreen.displayAppScreen();
        //appscreen.AppScreenLoader appScreenLoader = new appscreen.AppScreenLoader("Amy", myChats);


    }
}
