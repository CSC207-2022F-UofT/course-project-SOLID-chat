package use_cases.chat_initiation_use_case;




//chat-initation use case layer

import entities.chat.PrivateChat;

public interface ChatInputBoundry {

    PrivateChat create(ChatModel chatmodel);
}
