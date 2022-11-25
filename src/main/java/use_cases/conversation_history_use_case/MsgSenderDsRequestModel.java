package use_cases.conversation_history_use_case;

import entities.message.Message;

public class MsgSenderDsRequestModel {
    private String userID;
    private String chatID;
    private Message message;

    public MsgSenderDsRequestModel(String userID, String chatID, Message message) {
        this.userID = userID;
        this.chatID = chatID;
        this.message = message;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getChatID() {
        return chatID;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
