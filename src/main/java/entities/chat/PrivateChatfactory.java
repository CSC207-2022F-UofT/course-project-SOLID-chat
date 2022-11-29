package entities.chat;

//in Entity layer Interface tor create private chat.

public interface PrivateChatfactory {

    PrivateChat create(String name, String chatID, String recipientUsername);

}
