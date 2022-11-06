import java.time.LocalDateTime;

public class TextMessage extends Message {
    private final String senderID;
    private String msgContent;
    private final LocalDateTime timestamp;
    private final String msgID;

    public TextMessage(String senderID, String msgContent, LocalDateTime timestamp, String msgID) {
        this.senderID = senderID;
        this.msgContent = msgContent;
        this.timestamp = timestamp;
        this.msgID = msgID;
    }

    public String getSenderID() {
        return senderID;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getMsgID() {
        return msgID;
    }
}
