package interface_adapters.conversation_history_interface_adapters;

import use_cases.conversation_history_use_case.ConvHistResponseModel;

public interface ConvHistPresenter {
    ConvHistResponseModel prepareSuccessView(ConvHistResponseModel convHist);

    ConvHistResponseModel prepareFailView(String error);
}
