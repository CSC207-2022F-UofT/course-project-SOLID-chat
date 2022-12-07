package use_cases.user_login_use_cases;

import data_access.Database;
import entities.chat.Chat;
import entities.user_entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserLoginInteractor2 implements UserLoginInputBoundary, RetrieveEmail {
    private final UserLoginOutputBoundary chatPresenter;
    private final Database database;

    private final List<String> chatsStrings = new ArrayList<>();

    public UserLoginInteractor2(Database database, UserLoginOutputBoundary chatPresenter){
        this.database = database;
        this.chatPresenter = chatPresenter;
    }
    /**
     * @param username Username of the user
     * @param password password that the user entered
     * **/
    @Override
    public void login(String username, String password) {
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
            //Null pointer exception returns when the user is not in the database
            this.chatPresenter.setUserNotExists(true);
            this.chatPresenter.setChats(this.chatsStrings);
        }

    }

    @Override
    public UserLoginOutputBoundary getChatsPresenter() {
        return this.chatPresenter;
    }
    //Login the user without checking the password, in the case the user forgot the password
    //TODO: the code for this method is very similar to this.login, so common lines must be extracted to a new method
    @Override
    public void loginNoPassword(String username) {
        try {
            User user = database.getUser(username);
            this.chatPresenter.setUsername(username);
            this.chatPresenter.setPasswordNotMatched(false);
            this.chatPresenter.setUserNotExists(false);
            List<Chat> chats = user.getChats();
            for(Chat chat: chats){
                this.chatsStrings.add(chat.getName());
            }
            this.chatPresenter.setChats(this.chatsStrings);
        }catch(NullPointerException e){
            //Null pointer exception returns when the user is not in the database
            this.chatPresenter.setUserNotExists(true);
            this.chatPresenter.setChats(this.chatsStrings);
        }
    }

    @Override
    public String getEmail(String username) {
        try{
            User user = database.getUser(username);
            return user.getEmail();
        }catch(NullPointerException e){
            return null;
        }
    }
}
