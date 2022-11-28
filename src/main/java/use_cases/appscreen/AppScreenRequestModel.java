package use_cases.appscreen;

import interface_adapters.appscreen.AppScreenController;
import interface_adapters.appscreen.Refresh;

public class AppScreenRequestModel implements Refresh {
    private final AppScreenController appScreenController;

    public AppScreenRequestModel(String username, String chatID){
        this.appScreenController = new AppScreenController(username, chatID);
    }

    @Override
    public void refreshScreen(String chatID) {
        this.appScreenController.updateScreen();
    }
}
