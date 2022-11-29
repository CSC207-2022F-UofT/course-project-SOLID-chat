package use_cases.appscreen;

public class AppScreenResponseModel {

    public static void refreshScreen(String chatID) {
        AppScreenStatus.getAppScreen().refreshScreen(chatID);
    }
}
