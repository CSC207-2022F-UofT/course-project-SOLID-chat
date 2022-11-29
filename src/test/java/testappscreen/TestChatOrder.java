package testappscreen;

import entities.chat.Chat;
import entities.chat.PrivateChat;
import entities.user_entities.BasicUser;
import use_cases.appscreen.ChatOrder;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestChatOrder {

    static PrivateChat pv1 = new PrivateChat("name1", "1", "amy");
    static PrivateChat pv2 = new PrivateChat("name2", "2", "amy");
    static PrivateChat pv3 = new PrivateChat("name3", "3", "amy");
    static PrivateChat pv4 = new PrivateChat("name4", "4", "amy");
    static PrivateChat pv5 = new PrivateChat("name5", "5", "amy");
    static PrivateChat pv6 = new PrivateChat("name6", "6", "amy");

//    public static void main(String[] args) {
//
//        ArrayList<Chat> myChats = new ArrayList<>();
//        myChats.add(pv1);
//        myChats.add(pv2);
//        myChats.add(pv3);
//        myChats.add(pv4);
//        myChats.add(pv5);
//        myChats.add(pv6);
//        BasicUser amy = new BasicUser("amy", "123", "myEmail", myChats);
//
//        leastRecentChat();
//    }
//
//    public static void leastRecentChat(){
//        ChatOrder chatOrder = new ChatOrder("amy");
//        chatOrder.changeOrder(pv1);
//        assertEquals(chatOrder.getUserChats().get(chatOrder.getUserChats().size() - 1), pv1);
//    }
//
//    public static void moderatelyRecentChat(){
//        ChatOrder chatOrder = new ChatOrder("amy");
//        chatOrder.changeOrder(pv3);
//        assertEquals(chatOrder.getUserChats().get(chatOrder.getUserChats().size() - 1), pv3);
//    }
//
//    public static void mostRecentChat(){
//        ChatOrder chatOrder = new ChatOrder("amy");
//        chatOrder.changeOrder(pv6);
//        assertEquals(chatOrder.getUserChats().get(chatOrder.getUserChats().size() - 1), pv6);
//    }
}
