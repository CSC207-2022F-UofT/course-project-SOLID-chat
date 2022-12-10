package interface_adapters.conversation_history_interface_adapters;

import use_cases.conversation_history_use_case.*;

public class MsgSenderController {
    final MsgSenderInputBoundary msgSenderInputBoundary;

    public MsgSenderController(MsgSenderInputBoundary msgSenderInputBoundary) {
        this.msgSenderInputBoundary = msgSenderInputBoundary;
    }

    ConvHistResponseModel create(String senderID, Object msgContent, String chatID) {
        MsgSenderRequestModel requestModel = new MsgSenderRequestModel(senderID, msgContent, chatID);
        return msgSenderInputBoundary.create(requestModel);
    }
}
