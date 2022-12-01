package test_appscreen;

import entities.chat.Chat;
import entities.chat.PrivateChat;
import use_cases.appscreen_use_case.ChatOrder;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class TestChatOrder {

    static PrivateChat pv1 = new PrivateChat("name1", "1", "recipient1");
    static PrivateChat pv2 = new PrivateChat("name2", "2", "recipient2");
    static PrivateChat pv3 = new PrivateChat("name3", "3", "recipient3");
    static PrivateChat pv4 = new PrivateChat("name4", "4", "recipient4");
    static PrivateChat pv5 = new PrivateChat("name5", "5", "recipient5");
    static PrivateChat pv6 = new PrivateChat("name6", "6", "recipient6");

    public static void main(String[] args) {
        leastRecentChat();
        mostRecentChat();
        noExistingChats();
        newChatWithExistingChats();
        longChatList();
        multipleChanges();
    }
    /**
     * Test order when the least recent chat has an update
     */
    public static void leastRecentChat(){
        ArrayList<Chat> myChats = new ArrayList<>();
        myChats.add(pv1);
        myChats.add(pv2);
        myChats.add(pv3);
        ChatOrder chatOrder = new ChatOrder(myChats, pv1);
        chatOrder.changeOrder();
        assertEquals(pv1, myChats.get(2));

    }

    /**
     * Test order when the most recent chat has an update
     */
    public static void mostRecentChat(){
        ArrayList<Chat> myChats = new ArrayList<>();
        myChats.add(pv1);
        myChats.add(pv2);
        myChats.add(pv3);
        ChatOrder chatOrder = new ChatOrder(myChats, pv3);
        chatOrder.changeOrder();
        assertEquals(pv3, myChats.get(2));

    }

    /**
     * Test order when there are no existing chats
     */
    public static void noExistingChats(){
        ArrayList<Chat> myChats = new ArrayList<>();
        ChatOrder chatOrder = new ChatOrder(myChats, pv1);
        chatOrder.changeOrder();
        assertEquals(myChats.get(0), pv1);
        assertEquals(1, myChats.size());

    }
    /**
     * Test order when adding a new chat to a list of existing chats
     */
    public static void newChatWithExistingChats(){
        ArrayList<Chat> myChats = new ArrayList<>();
        myChats.add(pv1);
        myChats.add(pv2);
        myChats.add(pv3);
        myChats.add(pv4);
        ChatOrder chatOrder = new ChatOrder(myChats, pv5);
        chatOrder.changeOrder();
        assertEquals(pv5, myChats.get(4));

    }
    /**
     * Test order on a longer list
     */
    public static void longChatList(){
        ArrayList<Chat> myChats = new ArrayList<>();
        myChats.add(pv1);
        myChats.add(pv2);
        myChats.add(pv3);
        myChats.add(pv4);
        myChats.add(pv5);
        myChats.add(pv6);
        ChatOrder chatOrder = new ChatOrder(myChats, pv2);
        chatOrder.changeOrder();
        assertEquals(pv2, myChats.get(5));

    }
    /**
     * Test order for multiple changes
     */
    public static void multipleChanges(){
        ArrayList<Chat> myChats = new ArrayList<>();
        myChats.add(pv1);
        myChats.add(pv2);
        myChats.add(pv3);
        myChats.add(pv4);
        myChats.add(pv5);
        myChats.add(pv6);
        ChatOrder chatOrder = new ChatOrder(myChats, pv2);
        chatOrder.changeOrder();
        assertEquals(pv2, myChats.get(5));
        ChatOrder chatOrder2 = new ChatOrder(myChats, pv5);
        chatOrder2.changeOrder();
        assertEquals(pv6, myChats.get(3));
        assertEquals(pv1, myChats.get(0));
        chatOrder2.changeOrder();
        assertEquals(pv6, myChats.get(3));
        assertEquals(pv1, myChats.get(0));

    }



}
