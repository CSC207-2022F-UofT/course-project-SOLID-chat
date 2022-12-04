package use_cases.appscreen_use_case;

import interface_adapters.appscreen.AppScreenStatus;

public class AppScreenResponseModel {

    /**
     * Refresh AppScreen's current UI to display any changes
     */
    public static void refreshScreen() {
        try{
            AppScreenStatus.refreshAppScreen();
        } catch (Exception e) {
            throw new RuntimeException("Unable to refresh");
        }
    }
}
