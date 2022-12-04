package use_cases.conversation_history_use_case;

import data_access.InMemoryUserDataAccess;
import entities.message.Message;
import entities.message.MsgFactory;
import entities.message.TextMessage;
import interface_adapters.conversation_history_interface_adapters.ConvHistGateway;
import interface_adapters.conversation_history_interface_adapters.ConvHistPresenter;
import interface_adapters.conversation_history_interface_adapters.MsgSenderGateway;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MsgSenderInteractorTest {

    @Test
    void create() {
        // Initialize objects for MsgSenderInteractor

        // These 3 lines below does not affect functionality of code (here for testing purposes)
        ConvHistDsRequestModel dsRequestModel = new ConvHistDsRequestModel("1121", "207");
        ArrayList<Message> test = new ArrayList<Message>(Arrays.asList(new TextMessage("James",
                "First test message!", LocalDateTime.now(), "x")));

        // Create gateways, presenter, input boundary
        MsgSenderGateway msgSenderRepository = new InMemoryUserDataAccess(dsRequestModel, test);
        // currently not saving message in memory (next step: save it in a conv hist regardless of chatid)

        ConvHistGateway convHistRepository = new InMemoryUserDataAccess(dsRequestModel, test);
        MsgFactory msgFactory = new MsgFactory("text");  // create text message

        ConvHistPresenter presenter = new ConvHistPresenter() {
            @Override
            public ConvHistResponseModel prepareSuccessView(ConvHistResponseModel conversationHistory) {
                Message msg = conversationHistory.getConversationHistory().get(1);

                assertEquals("James", msg.getSenderID());
                assertEquals("First sent message!", ((TextMessage) msg).getMsgContent());
                assertNotNull(msg.getTimestamp());
                assertNotNull(msg.getMsgID());

                return null;
            }

            @Override
            public ConvHistResponseModel prepareFailView(String error) {
                fail("Unexpected failure.");
                return null;
            }
        };

        // Initialize input boundary
        MsgSenderInputBoundary msgSenderInputBoundary = new MsgSenderInteractor(msgSenderRepository,
                convHistRepository, msgFactory, presenter);

        // Create message and its metadata, packaged into a request model
        MsgSenderRequestModel msgSenderRequestModel = new MsgSenderRequestModel("James",
                "First sent message!", "1");

        // Run input boundary/interactor
        msgSenderInputBoundary.create(msgSenderRequestModel);

    }
}