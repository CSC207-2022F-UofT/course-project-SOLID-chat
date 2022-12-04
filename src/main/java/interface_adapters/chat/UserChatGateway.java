package interface_adapters.chat;

import entities.chat.Chat;

import java.util.ArrayList;

public interface UserChatGateway {

    ArrayList<Chat> getUserChats(String username);
}
