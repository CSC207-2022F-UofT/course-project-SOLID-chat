package use_cases.appscreen_use_case;

import interface_adapters.appscreen.AppScreenStatus;

import java.util.ArrayList;

public class AppScreenResponseModel {

    /**
     * Refresh AppScreen's current UI to display any changes
     */
    public static void refreshScreen(ArrayList<String> newChatNameOrder) {
        try{
            if (AppScreenStatus.appScreen != null){
                AppScreenStatus.changeAppScreenStatus(newChatNameOrder);
                AppScreenStatus.refreshAppScreen();
            }
        } catch (Exception e) {
            throw new RuntimeException("Unable to refresh");
        }
    }
}
