package screens.chat_screen;

import entities.chat.PrivateChat;
import interface_adapters.appscreen.AppScreenChatProxy;
import use_cases.chat_initiation_use_case.ChatInputBoundry;
import use_cases.chat_initiation_use_case.ChatModel;

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
        // create a private chat and
        this.newprivatechat = chatinputboundry.create(chatmodel);

        //Adding the chat to dashboard Apscreen and then update it in database
        new AppScreenChatProxy(currentusername,this.newprivatechat).proxyChat();
        return chatmodel ;

    }

    public PrivateChat getNewprivatechat() {
        return newprivatechat;
    }
}
