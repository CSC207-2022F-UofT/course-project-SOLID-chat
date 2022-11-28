package use_cases.conversation_history_use_case;

import entities.message.Message;
import interface_adapters.conversation_history_interface_adapters.ConvHistPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Interactor responsible for displaying this history upon opening a chat
 */
public class ConvHistInteractor implements ConvHistInputBoundary{
//public class ConvHistInteractor{
    /**
     * File and in-memory storage of users and their chats (incl. conversation history)
     */
    final ConvHistGateway userRepository;
    /**
     * Presenter with necessary information to display a chat's conversation history
     */
    final ConvHistPresenter convHistPresenter;

    /**
     * Construct ConvHistInteractor given storage, message factory, and presenter
     * //@param userDatabase storage
     * //@param convHistPresenter presenter
     */
    public ConvHistInteractor(ConvHistGateway userDatabase, ConvHistPresenter convHistPresenter) {
//    public ConvHistInteractor(ConvHistPresenter convHistPresenter) {
        this.userRepository = userDatabase;
        this.convHistPresenter = convHistPresenter;
    }

    /**
     * Displays conversation history upon opening a chat
     * @param requestModel input data
     * @return a response model for presenter
     */
    @Override
    public ConvHistResponseModel create(ConvHistRequestModel requestModel) {
        String userID = requestModel.getUserID();
        String chatID = requestModel.getChatID();

        ConvHistDsRequestModel dsRequestModel = new ConvHistDsRequestModel(userID, chatID);

        // Access database (code for database will become functional after PR for issue 15 is merged)
        List<Message> conversationHistory = userRepository.getConversationHistory(dsRequestModel);

        // Presenter show success view
//        List<Message> conversationHistory = new ArrayList<>();
        ConvHistResponseModel responseModel = new ConvHistResponseModel(conversationHistory);
        return convHistPresenter.prepareSuccessView(responseModel);
    }
}
