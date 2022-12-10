package entities.message;

import use_cases.emoji_manager.ChatEmo;

import java.time.LocalDateTime;

/**
 * A message with emoji description as its content (child of Message)
 */
public class EmojiMessage extends Message {
    /**
     * Emoji content of message
     */
    private ChatEmo emojiDescription;

    /**
     * Construct a text message
     * @param senderID ID of sender
     * @param emojiDescription emoji content
     * @param timestamp message timestamp
     * @param msgID ID of message
     */
    public EmojiMessage(String senderID, ChatEmo emojiDescription, LocalDateTime timestamp, String msgID) {
        super(senderID, timestamp, msgID);
        this.emojiDescription = emojiDescription;
    }

    /**
     * Gets content of a message
     * @return message content
     */
    public ChatEmo getEmojiDescription() {
        return emojiDescription;
    }

    /**
     * Sets content of a message
     * @param emojiDescription updated message content
     */
    public void setEmojiDescription(ChatEmo emojiDescription) {
        this.emojiDescription = emojiDescription;
    }
}
