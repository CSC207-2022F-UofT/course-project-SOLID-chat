package use_cases.appscreen_use_case;

import interface_adapters.appscreen.AppScreenStatus;

public class AppScreenResponseModel {

    /**
     * Refresh AppScreen's UI to display any changes
     */
    public static void refreshScreen() {
        AppScreenStatus.refreshAppScreen();
    }
}
