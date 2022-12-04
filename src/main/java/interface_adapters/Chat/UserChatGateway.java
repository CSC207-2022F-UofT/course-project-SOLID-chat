package interface_adapters.Chat;

import entities.chat.Chat;

import java.util.ArrayList;

public interface UserChatGateway {

    ArrayList<Chat> getUserChats(String username);
}
