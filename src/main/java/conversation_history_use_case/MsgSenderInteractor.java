package conversation_history_use_case;

import entities.Message;
import entities.MsgFactory;
import temp_persistence.UserDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Interactor responsible for adding messages to a chat's conversation history
 */
//public class ConvHistInteractor implements ConversationHistoryInputBoundary{
public class MsgSenderInteractor {
    /**
     * File and in-memory storage of users and their chats (incl. conversation history)
     */
    final UserDatabase userDatabase;
    /**
     * Factory for creating a new Message
     */
    final MsgFactory msgFactory;
//    /**
//     * Presenter with necessary information to display a chat's conversation history
//     */
//    final ConvHistPresenter convHistPresenter;

    /**
     * Construct ConvHistInteractor given storage, message factory, and presenter
     * @param userDatabase storage
     * @param msgFactory message factory
     * //@param convHistPresenter presenter
     */
//    public ConvHistInteractor(UserDatabase userDatabase, MsgFactory msgFactory, ConvHistPresenter convHistPresenter) {
    public MsgSenderInteractor(UserDatabase userDatabase, MsgFactory msgFactory) {
        this.userDatabase = userDatabase;
        this.msgFactory = msgFactory;  // msgType of MsgFactory specified in Main
//        this.convHistPresenter = convHistPresenter;
    }

    /**
     * Creates and adds message to a chat's conversation history
     * @param requestModel input data
     * @return a response model for presenter
     */
//    @Override
    public ConvHistResponseModel create(MsgSenderRequestModel requestModel) {
        // Create new message
        Message message = msgFactory.createMsg(requestModel.getSenderID(), requestModel.getMsgContent());

        // Add message to specified chat in user list
        String userID = requestModel.getSenderID();  // need a user in the chat to get the chat
        String chatID = requestModel.getChatID();

        MsgSenderDsRequestModel dsRequestModel = new MsgSenderDsRequestModel(userID, chatID, message);

        // Access database (code for database will become functional after PR for issue 15 is merged)
//        List<Message> conversationHistory  = userDatabase.saveMessage(dsRequestModel);

        // Presenter show success view (code to be written); below is temporary
        List<Message> conversationHistory = new ArrayList<>();
        return new ConvHistResponseModel(conversationHistory);
    }
}
