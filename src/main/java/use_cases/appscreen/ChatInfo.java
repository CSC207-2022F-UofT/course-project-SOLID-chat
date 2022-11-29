package use_cases.appscreen;

import data_access.UserDatabase;
import entities.chat.Chat;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ChatInfo {

    private final String username;
    private final String chatID;
    private final UserDatabase userDatabase = new UserDatabase(new File("user_accounts"));

    /**
     * Create an object pertaining to chat information
     * @param username Username of current user
     * @param chatID ID of the chat in context
     */
    public ChatInfo(String username, String chatID){
        this.username = username;
        this.chatID = chatID;
    }

    /**
     * Return the chat of the given user and specified chat ID
     * @return a chat
     */
    public Chat getChat(){
        try{
            ArrayList<Chat> userChats = userDatabase.getUserChats(username);
            for (Chat chat: userChats){
                if (chat.getChatID().equals(chatID)){
                    return chat;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to get indicated chat");
        }
        return null;
    }

    /**
     * Get the name of the chat
     * @return chat name
     */
    public String getChatName(){
        return getChat().getName();
    }

    /**
     * Return the date and time of the last message the chat
     * @return date and time of last update
     */
    public LocalDateTime getLastMessageTime(){
        return getChat().getLastUpdated();
    }

}
