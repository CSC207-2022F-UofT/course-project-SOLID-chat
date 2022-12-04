package entities.chat;
import entities.message.Message;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
// Chat is an abstract class
public class Chat implements Serializable {

    protected String name;
    protected String chatID;
    protected String senderUsername;

    // chat's conversation history
    protected ArrayList<Message> convHist;


    /**
     * Get the chat's name
     * @return name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Get the chat's ID
     * @return chatID
     */
    public String getChatID(){
        return this.chatID;
    }

    /**
     * Get the sender's username
     * @return senderUsername
     */
    public String getSenderUsername(){
        return this.senderUsername;
    }

    /**
     * Return this conversation history of the chat
     * @return convHist
     */
    public ArrayList<Message> getConvHist(){
        return new ArrayList<>(this.convHist);
    }

    /**
     * Add a message to the chat's conversation history when a message is sent or received
     * @param message Message that is sent or received
     */
    public void addToConvHist(Message message){
        this.convHist.add(message);
    }

    /**
     * Return of the timestamp of a chat's last updated to conversation history. If conversation
     * history is empty, return null
     * @return timestamp of last update (or null if empty)
     */
    public LocalDateTime getLastUpdated(){
        if (this.convHist.size() != 0) {
            return this.convHist.get(this.convHist.size() - 1).getTimestamp();
        }
        return null;
    }


}