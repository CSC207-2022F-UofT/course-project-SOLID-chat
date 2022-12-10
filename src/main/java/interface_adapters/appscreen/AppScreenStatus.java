package interface_adapters.appscreen;

import screens.appscreen.AppScreen;

import java.util.ArrayList;

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
     * Change the order of chat names that appear in app screen
     * @param newChatNameOrder The new order of chat names
     */
    public static void changeAppScreenStatus(ArrayList<String> newChatNameOrder){
        appScreen.setChatNames(newChatNameOrder);
    }

    /**
     * Refresh app screen to display any changes
     */
    public static void refreshAppScreen(){
        appScreen.refreshScreen();
    }
}
