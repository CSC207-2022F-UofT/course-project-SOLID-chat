package entities.chat;



//in Entity layer Interface .
/**
 * This an Interface which is implemented by the CommonPrivateChat class
 * it is responsible for creating  a new private chat.
 */


public interface PrivateChatFactory {

    PrivateChat create(String name, String chatID, String recipientUsername);

}
