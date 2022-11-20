package use_cases.app_screen_use_case;

public interface Refresh {
    boolean hasUpdate(String chatID);
    void updateScreen(String chatID);
}
