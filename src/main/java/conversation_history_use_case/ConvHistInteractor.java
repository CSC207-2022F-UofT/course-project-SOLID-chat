package conversation_history_use_case;

import entities.*;

import temp_persistence.UserDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Interactor responsible for displaying this history upon opening a chat
 */
//public class ConvHistInteractor implements ConversationHistoryInputBoundary{
public class ConvHistInteractor{
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
    public ConvHistInteractor(UserDatabase userDatabase, MsgFactory msgFactory) {
        this.userDatabase = userDatabase;
        this.msgFactory = msgFactory;  // msgType of MsgFactory specified in Main
//        this.convHistPresenter = convHistPresenter;
    }

    /**
     * Displays conversation history upon opening a chat
     * @param requestModel input data
     * @return a response model for presenter
     */
//    @Override
    public ConvHistResponseModel create(ConvHistRequestModel requestModel) {
        String userID = requestModel.getUserID();
        String chatID = requestModel.getChatID();

        ConvHistDsRequestModel dsRequestModel = new ConvHistDsRequestModel(userID, chatID);

        // Access database (code for database will become functional after PR for issue 15 is merged)
//        List<Message> conversationHistory = userDatabase.getConversationHistory(dsRequestModel);

        // Presenter show success view (code to be written); below is temporary
        List<Message> conversationHistory = new ArrayList<>();
        return new ConvHistResponseModel(conversationHistory);
    }
}
