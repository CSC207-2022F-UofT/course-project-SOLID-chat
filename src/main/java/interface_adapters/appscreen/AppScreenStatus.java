package interface_adapters.appscreen;

import screens.appscreen.AppScreen;

public class AppScreenStatus {
    public static AppScreen appScreen;

    /**
     * Save the reference to the current app screen instance
     * @param thisAppScreen The current app screen
     */
    public static void setAppScreen(AppScreen thisAppScreen){
        appScreen = thisAppScreen;
    }

    /**
     * Refresh app screen to display any changes
     */
    public static void refreshAppScreen(){
        appScreen.refreshScreen();
    }
}
