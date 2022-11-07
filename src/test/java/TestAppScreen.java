import java.util.ArrayList;

public class TestAppScreen {

    public static void main(String[] args) {
        User Amy = new User("amyyong11", "password", "email");
        ArrayList<User> users = new ArrayList<>();
        users.add(Amy);

        Chat myChat = new Chat(users);
        ArrayList<Chat> chats = new ArrayList<>();
        chats.add(myChat);
        AppScreen appScreen = new AppScreen(chats);

    }
}
