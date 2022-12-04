package entities.chat;

import entities.message.Message;

import java.util.ArrayList;

public class GroupChat extends Chat {

    /*
    From Chat, GroupChat has:
       String name;
        String chatID;
        String senderUsername;
        Arraylist<Message> convHist;
     */
    public ArrayList<String> groupMembers;

    /**
     * Create a private chat
     *
     * @param name           The name of the chat
     * @param chatID         The ID of the chat
     * @param senderUsername The username of the user sending the messages
     */
    public GroupChat(String name, String chatID, String senderUsername) {
        this.name = name;
        this.chatID = chatID;
        this.senderUsername = senderUsername;
        this.convHist = new ArrayList<Message>();
        this.groupMembers = new ArrayList<>();
    }

    /**
     * Return an arraylist of all the usernames of group members (not including the sender) in a group chat
     *
     * @return groupMembers
     */
    public ArrayList<String> getGroupMembers() {
        return new ArrayList<String>(this.groupMembers);
    }

    /**
     * Add a member to a group chat
     *
     * @param user The user to be added
     */
    public void addMember(String user) {
        try {
            this.groupMembers.add(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
