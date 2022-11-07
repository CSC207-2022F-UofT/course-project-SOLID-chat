package conversation_history_use_case;

import entities.*;

public class ConvHistInteractor implements ConversationHistoryInputBoundary{
    final UserDatabase userDatabase;
    final MsgFactory msgFactory;

    public ConvHistInteractor(UserDatabase userDatabase, MsgFactory msgFactory) {
        this.userDatabase = userDatabase;
        this.msgFactory = msgFactory;  // msgType of MsgFactory specified in Main
    }

    @Override
    public MsgSenderResponseModel create(MsgSenderRequestModel requestModel) {
        // Create new message
        Message message = msgFactory.createMsg(requestModel.getSenderID(), requestModel.getMsgContent());

        // Add message to chat in entity list
        userDatabase.save(); // save DsRequestModel (specific model for adding messages, vs. adding users/chats)

        // TODO: javadoc
        // TODO: finishing code outline (i.e. other scenario walkthru)
        // TODO: understanding all aspects of UserLoginCleanArchitecture example
    }
}
