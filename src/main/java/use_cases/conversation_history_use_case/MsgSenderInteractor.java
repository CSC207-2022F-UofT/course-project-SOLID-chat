package use_cases.conversation_history_use_case;

import entities.message.Message;
import entities.message.MsgFactory;
import interface_adapters.conversation_history_interface_adapters.ConvHistPresenter;
//import data_access.UserDatabase;

/**
 * Interactor responsible for adding messages to a chat's conversation history
 */
//public class ConvHistInteractor implements ConvHistInputBoundary{
public class MsgSenderInteractor {
    /**
     * File and in-memory storage of users and their chats (incl. conversation history)
     */
    final ConvHistGateway userRepository;
    /**
     * Presenter with necessary information to display a chat's conversation history
     */
    final ConvHistPresenter convHistPresenter;
    /**
     * Factory for creating a new Message
     */
    final MsgFactory msgFactory;

    /**
     * Construct ConvHistInteractor given storage, message factory, and presenter
     * //@param userDatabase storage
     * @param msgFactory message factory
     */
    public MsgSenderInteractor(ConvHistGateway userRepository, MsgFactory msgFactory, ConvHistPresenter convHistPresenter) {
//    public MsgSenderInteractor(MsgFactory msgFactory) {
        this.userRepository = userRepository;
        this.convHistPresenter = convHistPresenter;
        this.msgFactory = msgFactory;  // msgType of MsgFactory specified in Main
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
//        userDatabase.saveMessage(dsRequestModel);

        // Call convHistInteractor to display conversation history
        ConvHistRequestModel convHistRequestModel = new ConvHistRequestModel(userID, chatID);
        ConvHistInteractor convHistInteractor = new ConvHistInteractor(userRepository, convHistPresenter);
        return convHistInteractor.create(convHistRequestModel);
    }
}
