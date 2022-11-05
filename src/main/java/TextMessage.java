import java.time.LocalDateTime;

public class TextMessage extends Message {
    public final String SENDER_ID;
    public String msgContent;
    public final LocalDateTime TIMESTAMP;
    public final String MSG_ID;

    public TextMessage(String senderID, String msgContent, LocalDateTime timestamp, String msgID) {
        this.SENDER_ID = senderID;
        this.msgContent = msgContent;
        this.TIMESTAMP = timestamp;
        this.MSG_ID = msgID;
    }
}
