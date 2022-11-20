package use_cases.conversation_history_use_case;

public class MsgSenderRequestModel {
    private String senderID;
    private Object msgContent;
    private String chatID;

    public MsgSenderRequestModel(String senderID, Object msgContent, String chatID) {
        this.senderID = senderID;
        this.msgContent = msgContent;
        this.chatID = chatID;
    }

    public String getSenderID() {
        return senderID;
    }

    public void setSenderID(String senderID) {
        this.senderID = senderID;
    }

    public Object getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(Object msgContent) {
        this.msgContent = msgContent;
    }

    public String getChatID() {
        return chatID;
    }

    public void setChatID(String chatID) {
        this.chatID = chatID;
    }
}
