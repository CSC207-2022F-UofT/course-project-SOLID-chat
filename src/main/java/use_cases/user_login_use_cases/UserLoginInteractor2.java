package use_cases.user_login_use_cases;

import data_access.Database;
import entities.chat.Chat;
import entities.user_entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserLoginInteractor2 implements UserLoginInputBoundary {
    private final UserLoginOutputBoundary chatPresenter;
    private final Database database;

    private final List<String> chatsStrings = new ArrayList<>();

    public UserLoginInteractor2(Database database, UserLoginOutputBoundary chatPresenter){
        this.database = database;
        this.chatPresenter = chatPresenter;
    }

    @Override
    public void login(String username, String password) {
        //will update this.chatPresenter
        //TODO: change below, as its just temporary
        try {
            User user = database.getUser(username);
            this.chatPresenter.setUsername(username);
            this.chatPresenter.setPasswordNotMatched(!user.PasswordMatch(password));
            this.chatPresenter.setUserNotExists(false);
            List<Chat> chats = user.getChats();
            for(Chat chat: chats){
                this.chatsStrings.add(chat.getName());
            }
            this.chatPresenter.setChats(this.chatsStrings);
        }catch(NullPointerException e){
            this.chatPresenter.setUserNotExists(true);
            this.chatPresenter.setChats(this.chatsStrings);
        }

    }

    @Override
    public UserLoginOutputBoundary getChatsPresenter() {
        return this.chatPresenter;
    }
}
