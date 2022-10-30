import java.time.LocalDateTime;

public class MsgFactory {
    public Message createMsg(String msgType, int chatID, int senderID, Object msgContent) {
        if (msgType.equalsIgnoreCase("text")) {
            return TextMessage(chatID, senderID, (String) msgContent, LocalDateTime.now());
        } else {
            System.out.println("A " + msgType.toLowerCase() + " is an undefined message type for this program.");
            // TODO: implement exception
            return null;
        }
    }
}
