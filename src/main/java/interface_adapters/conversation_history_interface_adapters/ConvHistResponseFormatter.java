package interface_adapters.conversation_history_interface_adapters;

import use_cases.conversation_history_use_case.ConvHistResponseModel;

public class ConvHistResponseFormatter implements ConvHistPresenter {
    @Override
    public ConvHistResponseModel prepareSuccessView(ConvHistResponseModel convHist) {
        return convHist;
    }

    @Override
    public ConvHistResponseModel prepareFailView(String error) {
        return null;
    }
}
