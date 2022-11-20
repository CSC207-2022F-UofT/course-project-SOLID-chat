package conversation_history_use_case;

import entities.Message;

import java.util.List;

public class ConvHistResponseModel {
    private List<Message> conversationHistory;
    public ConvHistResponseModel(List<Message> conversationHistory) {
        this.conversationHistory = conversationHistory;
    }

    public List<Message> getConversationHistory() {
        return conversationHistory;
    }

    public void setConversationHistory(List<Message> conversationHistory) {
        this.conversationHistory = conversationHistory;
    }
}
