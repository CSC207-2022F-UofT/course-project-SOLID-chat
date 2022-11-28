package use_cases.appscreen;

import screens.appscreen.AppScreen;

public class AppScreenResponseModel {

    AppScreen appScreen;
    String chatID;
    public AppScreenResponseModel(AppScreen appScreen, String chatID){
        this.appScreen = appScreen;
        this.chatID = chatID;
        appScreen.refreshScreen(chatID);
    }
}
