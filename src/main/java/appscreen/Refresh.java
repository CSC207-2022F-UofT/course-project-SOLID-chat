package appscreen;

public interface Refresh {
    boolean hasUpdate(String chatID);
    void updateScreen(String chatID);
}
