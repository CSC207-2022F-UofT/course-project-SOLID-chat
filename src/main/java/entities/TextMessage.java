package entities;

import java.time.LocalDateTime;

/**
 * A message with text as its content (child of Message)
 */
public class TextMessage extends Message {
    /**
     * Text content of message
     */
    private String msgContent;

    /**
     * Construct a text message
     * @param senderID ID of sender
     * @param msgContent text content
     * @param timestamp message timestamp
     * @param msgID ID of message
     */
    public TextMessage(String senderID, String msgContent, LocalDateTime timestamp, String msgID) {
        super(senderID, timestamp, msgID);
        this.msgContent = msgContent;
    }

    /**
     * Gets text content of a message
     * @return message content
     */
    public String getMsgContent() {
        return msgContent;
    }

    /**
     * Sets text content of a message
     * @param msgContent updated message content
     */
    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }
}
