package use_cases.chat_initiation_use_case;


import entities.chat.PrivateChat;
import entities.chat.PrivateChatfactory;

import java.util.UUID;

public class ChatInteractor implements ChatInputBoundry{


    PrivateChatfactory chatfactory;


    //Add a DaTa base to check if exist or not
    public ChatInteractor(PrivateChatfactory chatfactory){

        this.chatfactory = chatfactory;

    }


    //create a private chat with the Recipient username that user typed in the textfield UI of the private chat.
    @Override
    public PrivateChat create(ChatModel chatmodel) {

        //check if in data exist later

        PrivateChat p= chatfactory.create(chatmodel.getRecipientusername(), UUID.randomUUID().toString(),chatmodel.getRecipientusername().toString());
        //
        return p;

    }


}
