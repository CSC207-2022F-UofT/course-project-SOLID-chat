package entities.chat;

import java.util.ArrayList;

/**
 * This class is a Private chat class, entity layer. containing the chat name, chat ID, Senderusername
 * which is the current user's username and the Recipient username with which the person is chatting.
 */

public class PrivateChat extends Chat {

    /*
    From Chat, PrivateChat has:
        String name;
        String chatID;
        String senderUsername;
        Arraylist<Message> convHist;
     */
    protected String recipientUsername;
    protected String senderUsername;

    /**
     * Create a private chat
     *
     * @param name  The name of the chat (also the username of the recipient)
     * @param chatID The ID of the chat
     * @param recipientUsername The user receiving the messages
     *
     *
     */
    public PrivateChat(String name, String chatID, String recipientUsername ){
        this.name = name;
        this.chatID = chatID;
        this.recipientUsername = recipientUsername;
        this.convHist = new ArrayList<>();
        System.out.println(22222);

    }




    /**
     * Get the recipient's username
     * @return recipientRecipient
     */
    public String getRecipientUsername(){
        return this.recipientUsername;
    }


    public void setRecipientUsername(String recipientUsername) {
        this.recipientUsername= recipientUsername;
    }

    public String getRecipientUsername(String recipientUsername) {
        return this.recipientUsername;
    }

    /**
     * Get the sender's username
     * @return senderRecipient
     */
    public String getSenderUsername(){
        return this.senderUsername;
    }
    public void setSenderUsername(String recipientUsername){
        this.recipientUsername = recipientUsername;
    }


}
