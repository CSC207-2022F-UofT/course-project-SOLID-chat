package use_cases.chat_initiation_use_case;

import entities.chat.PrivateChat;

//chat-initation use case layer

/**
 * This  is an Interface for creating a Private chat with the ChatModel ( Chat Model has The recipient
 * Username ). Chat Interactor class implements this Interface, so it has the create method.
 * Also, Controller passed this Interface in the construction and used the create method called
 * in the chatInteractor. This process will create a new private for the first time when the user clicks the
 * add button
 */


public interface ChatInputBoundry {

    PrivateChat create(ChatModel chatmodel);
}
