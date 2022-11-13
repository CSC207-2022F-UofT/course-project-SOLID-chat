package entities;
import java.util.ArrayList;
// Chat is an abstract class
public class Chat {

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
        return new ArrayList<Message>(this.convHist);
    }

    /**
     * Add a message to the chat's conversation history when a message is sent or received
     * @param message Message that is sent or received
     */
    public void sendRecieveMessage(Message message){
        this.convHist.add(message);
    }

}
