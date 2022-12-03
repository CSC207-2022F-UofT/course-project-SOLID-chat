package use_cases.conversation_history_use_case;

import entities.message.Message;
import entities.message.MsgFactory;
import interface_adapters.conversation_history_interface_adapters.ConvHistGateway;
import interface_adapters.conversation_history_interface_adapters.ConvHistPresenter;
import interface_adapters.conversation_history_interface_adapters.MsgSenderGateway;
//import data_access.UserDatabase;

/**
 * Interactor responsible for adding messages to a chat's conversation history
 */
public class MsgSenderInteractor implements MsgSenderInputBoundary{
    /**
     * File and in-memory storage of users and their chats (incl. conversation history) for this interactor
     */
    final MsgSenderGateway msgSenderRepository;
    /**
     * File and in-memory storage of users for ConvHistInteractor
     */
    final ConvHistGateway convHistRepository;
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
    public MsgSenderInteractor(MsgSenderGateway userRepository, ConvHistGateway convHistRepository,
                               MsgFactory msgFactory, ConvHistPresenter convHistPresenter) {
        this.msgSenderRepository = userRepository;
        this.convHistRepository = convHistRepository;
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
        msgSenderRepository.saveMessage(dsRequestModel);

        // Call convHistInteractor to display conversation history
        ConvHistRequestModel convHistRequestModel = new ConvHistRequestModel(userID, chatID);
        ConvHistInteractor convHistInteractor = new ConvHistInteractor(convHistRepository, convHistPresenter);
        return convHistInteractor.create(convHistRequestModel);
    }
}
