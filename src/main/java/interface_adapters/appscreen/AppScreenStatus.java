package interface_adapters.appscreen;

import screens.appscreen.AppScreen;

public class AppScreenStatus {

    public static AppScreen appScreen;

    /**
     * Create an empty constructor, so we can access the current app screen in a static context
     * (so we can access it globally)
     */
    public AppScreenStatus(){

    }

    /**
     * Set current status to be this app screen
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
