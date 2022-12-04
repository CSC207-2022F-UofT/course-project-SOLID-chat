package use_cases.appscreen_use_case;

import entities.chat.Chat;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ChatInfo {

    private final ArrayList<Chat> userChats;
    private final String chatName;

    /**
     * Create an object pertaining to chat information
     * @param chatName The name of the chat in context
     */
    public ChatInfo(ArrayList<Chat> chats, String chatName){
        this.userChats = chats;
        this.chatName = chatName;
    }

    /**
     * Return the date and time of the last message the chat
     * @return date and time of last update (or null if a chat with chatID does not exist in the user's list of chats)
     */
    public LocalDateTime getLastMessageTime(){
        try{
            for (Chat chat: userChats){
                if (chat.getName().equals(chatName)){
                    return chat.getLastUpdated();
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to get indicated chat");
        }
        return null;
    }

}
