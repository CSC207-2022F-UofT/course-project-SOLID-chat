package interface_adapters.conversation_history_interface_adapters;

import use_cases.conversation_history_use_case.MsgSenderDsRequestModel;

public interface MsgSenderGateway {
    void saveMessage(MsgSenderDsRequestModel dsRequestModel);
}