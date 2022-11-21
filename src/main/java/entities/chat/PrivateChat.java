package entities.chat;

import entities.message.Message;

import java.util.ArrayList;

public class PrivateChat extends Chat {

    /*
    From Chat, PrivateChat has:
        String name;
        String chatID;
        String senderUsername;
        Arraylist<Message> convHist;
     */
    protected String recipientUsername;

    /**
     * Create a private chat
     *
     * @param name  The name of the chat (also the username of the recipient)
     * @param chatID The ID of the chat
     * @param senderUsername    The user sending the messages
     * @param recipientUsername The user receiving the messages
     *
     */
    public PrivateChat(String name, String chatID, String senderUsername, String recipientUsername ){
        this.name = name;
        this.chatID = chatID;
        this.senderUsername = senderUsername;
        this.recipientUsername = recipientUsername;
        this.convHist = new ArrayList<Message>();
    }


    /**
     * Get the recipient's username
     * @return senderRecipient
     */
    public String getRecipientUsername(){
        return this.recipientUsername;
    }

    public void setRecipientUsername(String recipientUsername) {
        this.recipientUsername= recipientUsername;
    }

    public String getSenderUsername(){
        return this.senderUsername;
    }
    public void setSenderUsername(String recipientUsername){
        this.recipientUsername = recipientUsername;
    }


}
