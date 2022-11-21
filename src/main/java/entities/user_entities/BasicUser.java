package entities.user_entities;

import java.util.ArrayList;
import entities.chat;

public class BasicUser extends User{
    public BasicUser(String Username, String Password, String Email, ArrayList<Chat> userChats){
        super(Username, Password, Email, userChats);
    }
}
