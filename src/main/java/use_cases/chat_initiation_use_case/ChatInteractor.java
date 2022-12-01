package use_cases.chat_initiation_use_case;


import entities.chat.PrivateChat;
import entities.chat.PrivateChatFactory;

import java.util.UUID;

public class ChatInteractor implements ChatInputBoundry{


    PrivateChatFactory chatFactory;


    //Add a DaTa base to check if exist or not
    public ChatInteractor(PrivateChatFactory chatFactory){

        this.chatFactory = chatFactory;

    }


    //create a private chat with the Recipient username that user typed in the textfield UI of the private chat.
    @Override
    public PrivateChat create(ChatModel chatmodel) {

        //check if in data exist later

        PrivateChat p= chatFactory.create(chatmodel.getRecipientusername(), UUID.randomUUID().toString(),chatmodel.getRecipientusername().toString());
        //
        return p;

    }


}
