package entities.chat;

public class CommonPrivatechat implements PrivateChatFactory{

    @Override
    public PrivateChat create(String name, String chatID, String recipientUsername) {
        return new PrivateChat(name,chatID,recipientUsername);
    }

}
