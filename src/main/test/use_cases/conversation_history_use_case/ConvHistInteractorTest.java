package use_cases.conversation_history_use_case;

import entities.message.*;
import org.junit.Test;
import use_cases.conversation_history_use_case.*;
import interface_adapters.conversation_history_interface_adapters.*;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import data_access.*;

//import static org.junit.jupiter.api.Assertions.*;

class ConvHistInteractorTest {

    @Test
    void create() {
//        ConvHistGateway convHistRepository = new UserDatabase();

        ConvHistPresenter presenter = new ConvHistPresenter() {
            @Override
            public ConvHistResponseModel prepareSuccessView(ConvHistResponseModel conversationHistory) {
                // TODO: Finish code for testing
                return null;
            }

            @Override
            public ConvHistResponseModel prepareFailView(String error) {
//                fail("Unexpected failure.");
                return null;
            }
        };

//        ConvHistInputBoundary interactor = new ConvHistInteractor(
//            convHistRepository, presenter
//        );

        ConvHistRequestModel inputData = new ConvHistRequestModel("1121", "207");
//        interactor.create(inputData);

    }
}
