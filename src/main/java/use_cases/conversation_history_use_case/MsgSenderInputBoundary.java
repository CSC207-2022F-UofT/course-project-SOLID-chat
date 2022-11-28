package use_cases.conversation_history_use_case;

public interface MsgSenderInputBoundary {
    ConvHistResponseModel create(MsgSenderRequestModel requestModel);
}
