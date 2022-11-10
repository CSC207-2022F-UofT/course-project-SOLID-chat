package conversation_history_use_case;

import entities.*;

/**
 * Interactor responsible for adding messages to a chat's conversation history and displaying this history upon opening
 * a chat
 */
public class ConvHistInteractor implements ConversationHistoryInputBoundary{
    /**
     * File and in-memory storage of users nad their chats (incl. conversation history)
     */
    final UserDatabase userDatabase;
    /**
     * Factory for creating a new Message
     */
    final MsgFactory msgFactory;
    /**
     * Presenter with necessary information to display a chat's conversation history
     */
    final ConvHistPresenter convHistPresenter;

    /**
     * Construct ConvHistInteractor given storage, message factory, and presenter
     * @param userDatabase storage
     * @param msgFactory message factory
     * @param convHistPresenter presenter
     */
    public ConvHistInteractor(UserDatabase userDatabase, MsgFactory msgFactory, ConvHistPresenter convHistPresenter) {
        this.userDatabase = userDatabase;
        this.msgFactory = msgFactory;  // msgType of MsgFactory specified in Main
        this.convHistPresenter = convHistPresenter;
    }

    /**
     * Creates and adds message to a chat's conversation history
     * @param requestModel input data
     * @return a presenter
     */
    @Override
    public MsgSenderResponseModel create(MsgSenderRequestModel requestModel) {
        // Create new message
        Message message = msgFactory.createMsg(requestModel.getSenderID(), requestModel.getMsgContent());

        // Add message to specified chat in user list
        userDatabase.save(); // save DsRequestModel (specific request model for adding messages, vs. adding users/chats)

        // TODO: finishing code outline (i.e. presenter, reviewing written code)
        // TODO: understanding all aspects of UserLoginCleanArchitecture example
    }

    /**
     * Displays conversation history upon opening a chat
     * @param requestModel input data
     * @return a presenter
     */
    @Override
    public MsgSenderResponseModel create(ConvHistRequestModel requestModel) {
        String userID = requestModel.getChatID(); // TODO: do we need to pass this
        String chatID = requestModel.getChatID();

        // Find chat under specified User
        Chat chat = userDatabase.getAccounts().get(userID).getChats().get(chatID);

    }
}
