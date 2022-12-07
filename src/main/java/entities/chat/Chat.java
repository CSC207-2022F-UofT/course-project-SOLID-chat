package entities.chat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
// Chat is an abstract class

/**
 * This a chat abstarct class and the private chat extend this clss
 *
 */
public class Chat implements Serializable {

    /**
     * name of chat sender which same as teh Recipent username that user is typing with
     */
    protected String name;

    /**
     * Chat ID of chat sender
     */
    protected String chatID;

    /**
     * sender username of chat (UUID)
     */
    protected String senderUsername;

    /**
     * Array List of messages that users has typed
     */

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