
import screens.appscreen.AppScreen;
import java.util.ArrayList;

// this is just for testing the UI
public class TestAppScreenUI {

    public static void main(String[] args) {

        ArrayList<String> chatNames = new ArrayList<>();
        chatNames.add("james");
        chatNames.add("nasim");

        AppScreen appScreen = new AppScreen("amy", chatNames);
        chatNames.add("parmis");
        appScreen.refreshScreen();


    }
}
