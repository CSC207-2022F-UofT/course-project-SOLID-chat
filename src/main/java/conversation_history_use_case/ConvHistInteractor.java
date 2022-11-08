package conversation_history_use_case;

import entities.*;

public class ConvHistInteractor implements ConversationHistoryInputBoundary{
    final UserDatabase userDatabase;
    final MsgFactory msgFactory;

    public ConvHistInteractor(UserDatabase userDatabase, MsgFactory msgFactory) {
        this.userDatabase = userDatabase;
        this.msgFactory = msgFactory;  // msgType of MsgFactory specified in Main
    }

    /**
     *
     * @param requestModel
     * @return
     */
    @Override
    public MsgSenderResponseModel create(MsgSenderRequestModel requestModel) {
        // Create new message
        Message message = msgFactory.createMsg(requestModel.getSenderID(), requestModel.getMsgContent());

        // Add message to specified chat in user list
        userDatabase.save(); // save DsRequestModel (specific request model for adding messages, vs. adding users/chats)

        // TODO: javadoc
        // TODO: finishing code outline (i.e. presenter, reviewing written code)
        // TODO: understanding all aspects of UserLoginCleanArchitecture example
    }

    /**
     *
     * @param requestModel
     * @return
     */
    @Override
    public MsgSenderResponseModel create(ConvHistRequestModel requestModel) {
        String userID = requestModel.getChatID(); // TODO: do we need to pass this
        String chatID = requestModel.getChatID();

        // Find chat under specified User
        Chat chat = userDatabase.getAccounts().get(userID).getChats().get(chatID);

    }
}
