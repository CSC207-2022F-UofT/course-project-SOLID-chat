package screens.chat_screen;

import entities.chat.PrivateChat;
import use_cases.chat_initiation_use_case.ChatInputBoundry;
import use_cases.chat_initiation_use_case.ChatModel;

public class ChatController {

    ChatInputBoundry chatinputboundry;
    String username;
    PrivateChat newprivatechat;
    public ChatController(ChatInputBoundry chatinputboundry, String username) {
        this.chatinputboundry = chatinputboundry;
        this.username = username;
    }

    // this method is used in UI to set the recipient username
    public ChatModel create (String username){
        ChatModel chatmodel = new ChatModel(username);
        // create a private chat and
        this.newprivatechat = chatinputboundry.create(chatmodel);
        return chatmodel ;

    }

    public PrivateChat getNewprivatechat() {
        return newprivatechat;
    }
}
