package use_cases.app_screen_use_case;

import entities.chat.Chat;

public interface AppScreenController{
    Chat getChat(String chatID);

}
