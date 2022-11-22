package use_cases.conversation_history_use_case;

public interface ConvHistInputBoundary {
    ConvHistResponseModel create(ConvHistRequestModel requestModel);
}
