package entities.chat;

// Entity layer.
/**
 * This class  implements teh PrivateChatFactory Interfaces and Create a new obj of a privatechat
 * given their name, chatID and recipient Username
 */

public class CommonPrivatechat implements PrivateChatFactory{

    @Override
    public PrivateChat create(String name, String chatID, String recipientUsername) {
        return new PrivateChat(name,chatID,recipientUsername);
    }

}
