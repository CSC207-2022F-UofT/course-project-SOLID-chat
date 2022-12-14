package data_access;

//import entities.chat.Chat;
//import interface_adapters.User_search_IA.IRetrieveList;
//import interface_adapters.user_registration_interface_adapters.UserExists;
//import entities.user_entities.User;
//import interface_adapters.profile_modification_IA.UserModificationGateway;
//import use_cases.user_registration_use_cases.UserCreator;
//import entities.user_entities.UserFactory;
//import interface_adapters.Chat.UserChatGateway;
//import interface_adapters.User_search_IA.UserRetriever;

import entities.message.Message;
import use_cases.conversation_history_use_case.ConvHistDsRequestModel;
import interface_adapters.conversation_history_interface_adapters.ConvHistGateway;
import use_cases.conversation_history_use_case.MsgSenderDsRequestModel;
import interface_adapters.conversation_history_interface_adapters.MsgSenderGateway;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

//public class UserDatabase implements UserExists, UserRetriever, UserCreator, IRetrieveList, UserModificationGateway, UserChatGateway {
public class InMemoryUserDataAccess implements ConvHistGateway, MsgSenderGateway {

    final private Map<ConvHistDsRequestModel, List<Message>> accountList = new HashMap<>();

    public InMemoryUserDataAccess(ConvHistDsRequestModel dsRequestModel, List<Message> convHist) {
        accountList.put(dsRequestModel, convHist);
    }

    @Override
    public List<Message> getConversationHistory(ConvHistDsRequestModel dsRequestModel) {
        return accountList.get(dsRequestModel);
    }

    @Override
    public void saveMessage(MsgSenderDsRequestModel dsRequestModel) {
        String userID = dsRequestModel.getUserID();
        String chatID = dsRequestModel.getChatID();
        Message message = dsRequestModel.getMessage();

        // For running MsgSenderInteractor, will not make edits for now
    }

//    final private Map<String, User> accountList = new HashMap<>();
//
//    /**
//     * Gets a chat's conversation history (from memory not persisting storage)
//     * @param dsRequestModel input data containing user ID, chat ID
//     * @return a chat's conversation history
//     */
//    public ArrayList<Message> getConversationHistory(ConvHistDsRequestModel dsRequestModel) {
//        String userID = dsRequestModel.getUserID();
//        String chatID = dsRequestModel.getChatID();
//
//        // Find chat under specified Entities.User_Entities.User
//        Chat chat = this.getUser(userID).getChat(chatID);
//
//        return Chat.getConversationHistory();
//    }
}
