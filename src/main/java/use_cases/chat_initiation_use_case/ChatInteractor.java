package use_cases.chat_initiation_use_case;


import entities.chat.PrivateChat;
import entities.chat.PrivateChatFactory;

import java.util.UUID;

// use case of chat-initiation

/**
 * This class Implemented the ChaInputBoundry which has the ovveriden create method .
 * Create method create a new private chat with the given Recipeint usernamed saved in ChatModel.
 *
 */


public class ChatInteractor implements ChatInputBoundry{

    /**
     * Chat Factory of the Chat Iteractor.
     */

    PrivateChatFactory chatFactory;

    /**
     * Construct a new ChatInteractor
     * @param chatFactory is obj of PriavteChatFactory when we use
     * create method it will create a new private chat
     */

    public ChatInteractor(PrivateChatFactory chatFactory){

        this.chatFactory = chatFactory;

    }


    /**
     *This method creates a private chat obj for the first time with a given Riciepnt username
     * passed by the ChatModel and set a random ChatID.
     *-
     * This method will be called in the Controller via the ChatInputBoundry
     *  to obey the rule of clean architect
     *
     * @return  Private chat
     */


    //create a private chat with the Recipient username that user typed in the textfield UI of the private chat.
    @Override
    public PrivateChat create(ChatModel chatmodel) {


        return chatFactory.create(chatmodel.getRecipientusername(), UUID.randomUUID().toString(),chatmodel.getRecipientusername());

    }


}
