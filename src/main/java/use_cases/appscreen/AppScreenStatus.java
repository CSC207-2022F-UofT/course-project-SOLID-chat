package use_cases.appscreen;

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
     * Return the current app screen
     * @return current app screen
     */
    public static AppScreen getAppScreen(){
        return appScreen;
    }
}
