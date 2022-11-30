package screens.chat_screen;

import data_access.UserDatabase;
import entities.chat.PrivateChat;
import interface_adapters.appscreen.AppScreenChatProxy;
import use_cases.chat_initiation_use_case.ChatInputBoundry;
import use_cases.chat_initiation_use_case.ChatModel;

import java.io.File;

public class ChatController {

    ChatInputBoundry chatinputboundry;
    PrivateChat newprivatechat;
    String currentusername;

    public ChatController(ChatInputBoundry chatinputboundry, String currentusername) {
        this.chatinputboundry = chatinputboundry;
        this.currentusername= currentusername;
    }

    // this method is used in UI to set the recipient username
    public ChatModel create (String username){
        ChatModel chatmodel = new ChatModel(username);

        UserDatabase userdatabase = new UserDatabase(new File("user_accounts"));

        if (userdatabase.UserExists(username)) {

            // create a private chat obj
            this.newprivatechat = chatinputboundry.create(chatmodel);

            //Adding the chat to dashboard Appscreen and then update it in database
            new AppScreenChatProxy(currentusername, this.newprivatechat).proxyChat();
            return chatmodel;

        }
        else{
            // adding a window
        }

//        // create a private chat and
//        this.newprivatechat = chatinputboundry.create(chatmodel);
//
//        //Adding the chat to dashboard Apscreen and then update it in database
//        new AppScreenChatProxy(currentusername,this.newprivatechat).proxyChat();
//        return chatmodel ;
        return null;

    }

    public PrivateChat getNewprivatechat() {
        return newprivatechat;
    }
}
