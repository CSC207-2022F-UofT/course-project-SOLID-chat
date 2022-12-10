
import screens.appscreen.AppScreen;
import java.util.ArrayList;

// this is just for testing the UI
public class TestAppScreenUI {

    public static void main(String[] args) {

        ArrayList<String> chatNames = new ArrayList<>();
        chatNames.add("bin");
        chatNames.add("emma");
        chatNames.add("madhav");
        chatNames.add("parmis");
        chatNames.add("nasim");

        AppScreen appScreen = new AppScreen("amy", chatNames);
        chatNames.add("james");
        appScreen.refreshScreen();


    }
}
