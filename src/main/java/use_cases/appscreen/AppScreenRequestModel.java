package use_cases.appscreen;

import interface_adapters.appscreen.AppScreenController;

public class AppScreenRequestModel {

    public AppScreenRequestModel(String username, String chatID){
        AppScreenController appScreenController = new AppScreenController(username, chatID);
        appScreenController.updateScreen();
        AppScreenResponseModel.refreshScreen(chatID);
    }

}
