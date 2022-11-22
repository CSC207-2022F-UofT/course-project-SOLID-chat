package use_cases.conversation_history_use_case;

import entities.message.Message;

import java.util.ArrayList;
import java.util.List;

public interface ConvHistGateway {
    public List<Message> getConversationHistory(ConvHistDsRequestModel dsRequestModel);
}