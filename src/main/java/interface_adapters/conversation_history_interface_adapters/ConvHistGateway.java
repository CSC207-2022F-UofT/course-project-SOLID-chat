package interface_adapters.conversation_history_interface_adapters;

import entities.message.Message;
import use_cases.conversation_history_use_case.ConvHistDsRequestModel;

import java.util.List;

public interface ConvHistGateway {
    List<Message> getConversationHistory(ConvHistDsRequestModel dsRequestModel);
}