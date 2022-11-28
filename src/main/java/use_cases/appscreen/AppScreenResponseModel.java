package use_cases.appscreen;

import entities.chat.Chat;
import interface_adapters.appscreen.UserAppScreenGateway;

import java.util.ArrayList;

public class AppScreenResponseModel {

    public static void refreshScreen() {
        AppScreenStatus.getAppScreen().refreshScreen();
    }
}
