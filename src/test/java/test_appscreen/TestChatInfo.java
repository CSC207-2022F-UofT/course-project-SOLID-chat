package test_appscreen;

import entities.chat.Chat;
import entities.chat.PrivateChat;
import use_cases.appscreen_use_case.ChatInfo;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestChatInfo {

    static PrivateChat pv1 = new PrivateChat("name1", "1", "recipient1");
    static PrivateChat pv2 = new PrivateChat("name2", "2", "recipient2");
    static PrivateChat pv3 = new PrivateChat("name3", "3", "recipient3");
    static PrivateChat pv4 = new PrivateChat("name4", "4", "recipient4");
    static PrivateChat pv5 = new PrivateChat("name5", "5", "recipient5");
    static PrivateChat pv6 = new PrivateChat("name6", "6", "recipient6");

    static ArrayList<Chat> myChats = new ArrayList<>();

    public static void main(String[] args) {
        myChats.add(pv1);
        myChats.add(pv2);
        myChats.add(pv3);
        myChats.add(pv4);
        myChats.add(pv5);
        myChats.add(pv6);
        testGetChatName();
        testGetChatLastMessageTime();
        testNonExistentChat();
        testMostRecentChat();
    }

    /**
     * Test getting the chat name of an existing chat
     */
    public static void testGetChatName(){
        ChatInfo chatInfo = new ChatInfo(myChats, pv1.getChatID());
        assertEquals("name1", chatInfo.getChatName());
    }
    /**
     * Test getting the time of an existing chat
     */
    public static void testGetChatLastMessageTime(){
        ChatInfo chatInfo = new ChatInfo(myChats, pv1.getChatID());
        assertEquals(pv1.getLastUpdated(), chatInfo.getLastMessageTime());
    }
    /**
     * Test getting the chat name and time of a non-existent chat
     */
    public static void testNonExistentChat(){
        PrivateChat pv7 = new PrivateChat("name7", "7", "recipient7");
        ChatInfo chatInfo = new ChatInfo(myChats, pv7.getChatID());
        assertNull(chatInfo.getChatName());
        assertNull(chatInfo.getLastMessageTime());
    }
    /**
     * Test getting the chat name and time of the most recent chat
     */
    public static void testMostRecentChat(){
        ChatInfo chatInfo = new ChatInfo(myChats, pv6.getChatID());
        assertEquals(pv6.getLastUpdated(), chatInfo.getLastMessageTime());
        assertEquals(pv6.getName(), chatInfo.getChatName());
    }


}
