package use_cases.conversation_history_use_case;

import data_access.InMemoryUserDataAccess;
import data_access.UserDatabase;
import entities.chat.Chat;
import entities.chat.PrivateChat;
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

//        // These 3 lines below does not affect functionality of code (here for testing purposes)
//        ConvHistDsRequestModel dsRequestModel = new ConvHistDsRequestModel("1121", "207");
//        ArrayList<Message> test = new ArrayList<Message>(Arrays.asList(new TextMessage("James",
//                "First test message!", LocalDateTime.now(), "x")));
//
//        // Create gateways, presenter, input boundary
//        MsgSenderGateway msgSenderRepository = new InMemoryUserDataAccess(dsRequestModel, test);
//        // currently not saving message in memory (next step: save it in a conv hist regardless of chatid)
//
//        ConvHistGateway convHistRepository = new InMemoryUserDataAccess(dsRequestModel, test);  // not sure how to make
//        // these refer to the same object (not sure if casting works)

        UserDatabase repository = new UserDatabase();

        // Create user
        repository.createUser("james", "123456", "james@solid-chat-csc207.com", "basic");

        // Create chat
        Chat newChat = new PrivateChat("test_receiver", "1", "test_receiver");

        repository.addChatToUser("james", newChat);


        MsgFactory msgFactory = new MsgFactory("text");  // create text message

        ConvHistPresenter presenter = new ConvHistPresenter() {
            @Override
            public ConvHistResponseModel prepareSuccessView(ConvHistResponseModel conversationHistory) {
                Message msg = conversationHistory.getConversationHistory().get(0);  // Note this retrieves message in
                // test arraylist, not added message because it was not added to database; but this doesn't solve
                // nullpointerex

                assertEquals("james", msg.getSenderID());
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
        MsgSenderInputBoundary msgSenderInputBoundary = new MsgSenderInteractor(repository,
                repository, msgFactory, presenter);

        // Create message and its metadata, packaged into a request model
        MsgSenderRequestModel msgSenderRequestModel = new MsgSenderRequestModel("james",
                "First sent message!", "1");

        // Run input boundary/interactor
        msgSenderInputBoundary.create(msgSenderRequestModel);

    }
}