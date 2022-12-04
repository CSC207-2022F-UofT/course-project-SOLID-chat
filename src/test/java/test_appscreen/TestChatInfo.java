package test_appscreen;

import entities.chat.Chat;
import entities.chat.PrivateChat;
import org.junit.jupiter.api.Test;
import use_cases.appscreen_use_case.ChatInfo;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TestChatInfo {

    static PrivateChat pv1 = new PrivateChat("name1", "1", "recipient1");
    static PrivateChat pv2 = new PrivateChat("name2", "2", "recipient2");
    static PrivateChat pv3 = new PrivateChat("name3", "3", "recipient3");

    /**
     * Test getting the time of an existing chat
     */
    @Test
    public void testGetChatLastMessageTime(){
        ArrayList<Chat> myChats = new ArrayList<>();
        myChats.add(pv1);
        ChatInfo chatInfo = new ChatInfo(myChats, pv1.getName());
        assertEquals(pv1.getLastUpdated(), chatInfo.getLastMessageTime());
    }
    /**
     * Test getting the last message time of a non-existent chat
     */
    @Test
    public void testNonExistentChat(){
        ArrayList<Chat> myChats = new ArrayList<>();
        PrivateChat pv7 = new PrivateChat("name7", "7", "recipient7");
        ChatInfo chatInfo = new ChatInfo(myChats, pv7.getName());
        assertNull(chatInfo.getLastMessageTime());
    }
    /**
     * Test getting the last message time of the most recent chat
     */
    @Test
    public void testMostRecentChat(){
        ArrayList<Chat> myChats = new ArrayList<>();
        myChats.add(pv1);
        myChats.add(pv2);
        myChats.add(pv3);
        ChatInfo chatInfo = new ChatInfo(myChats, pv3.getName());
        assertEquals(pv3.getLastUpdated(), chatInfo.getLastMessageTime());
    }

    /**
     * Test getting the last message time of the least recent chat
     */
    @Test
    public void testLeastRecentChat(){
        ArrayList<Chat> myChats = new ArrayList<>();
        myChats.add(pv1);
        myChats.add(pv2);
        myChats.add(pv3);
        ChatInfo chatInfo = new ChatInfo(myChats, pv1.getName());
        assertEquals(pv1.getLastUpdated(), chatInfo.getLastMessageTime());
    }


}
