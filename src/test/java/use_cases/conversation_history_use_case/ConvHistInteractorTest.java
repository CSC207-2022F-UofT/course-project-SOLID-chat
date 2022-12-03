package use_cases.conversation_history_use_case;

import data_access.InMemoryUserDataAccess;
import entities.message.*;
import interface_adapters.conversation_history_interface_adapters.*;
//import data_access.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
class ConvHistInteractorTest {

    @Test
    void create() {
        ConvHistDsRequestModel dsRequestModel = new ConvHistDsRequestModel("1121", "207");
        ArrayList<Message> test = new ArrayList<Message>(Arrays.asList(new TextMessage("James",
                "First test message!", LocalDateTime.now(), "x")));

        ConvHistGateway convHistRepository = new InMemoryUserDataAccess(dsRequestModel, test);

        ConvHistPresenter presenter = new ConvHistPresenter() {
            @Override
            public ConvHistResponseModel prepareSuccessView(ConvHistResponseModel conversationHistory) {
                Message msg = conversationHistory.getConversationHistory().get(0);

                assertEquals("James", msg.getSenderID());
                assertEquals("First test message!", ((TextMessage) msg).getMsgContent());
                assertNotNull(msg.getTimestamp());
                assertEquals("x", msg.getMsgID());

                return null;
            }

            @Override
            public ConvHistResponseModel prepareFailView(String error) {
                fail("Unexpected failure.");
                return null;
            }
        };

        ConvHistInputBoundary interactor = new ConvHistInteractor(convHistRepository, presenter);

        ConvHistRequestModel inputData = new ConvHistRequestModel("1121", "207");
        interactor.create(inputData);
    }
}