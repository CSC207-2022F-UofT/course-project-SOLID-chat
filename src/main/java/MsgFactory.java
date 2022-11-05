import java.time.LocalDateTime;
import java.util.UUID;

public class MsgFactory {
    public Message createMsg(String msgType, String senderID, Object msgContent) {
        if (msgType.equalsIgnoreCase("text")) {
            return new TextMessage(senderID, (String) msgContent, LocalDateTime.now(), UUID.randomUUID().toString());
            // ID of message's sender, message text/content, timestamp of message, ID of message
        } else {
            System.out.println("A " + msgType.toLowerCase() + " is an undefined message type for this program.");
            // TODO: implement exception
            return null;
        }
    }
}
