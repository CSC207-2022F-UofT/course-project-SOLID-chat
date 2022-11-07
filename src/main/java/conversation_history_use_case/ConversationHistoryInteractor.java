package conversation_history_use_case;

import entities.*;

public class ConversationHistoryInteractor implements ConversationHistoryInputBoundary{
    final MsgFactory msgFactory;

    public ConversationHistoryInteractor(MsgFactory msgFactory) {
        this.msgFactory = msgFactory;
    }

    @Override
    public MsgSenderResponseModel create(MsgSenderRequestModel requestModel) {
        // Create new message
        Message message = msgFactory.createMsg(requestModel.getMsgType(), requestModel.getSenderID(),
                requestModel.getMsgContent());

    }
}
