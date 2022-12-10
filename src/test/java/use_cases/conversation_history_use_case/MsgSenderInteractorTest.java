/**
 * Test for MsgSenderInteractor
 * Important note to reader: To run this test successfully, there cannot be a user_accounts file in course-project-
 * SOLID-chat (outermost folder). Please move that file away temporarily when running this test and move it back if
 * needed.
 */

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
        // Setting up the use case (doing it manually here but will be done by user when using program)
        UserDatabase repository = new UserDatabase();

        // 1. Create users
        repository.createUser("james", "123456", "james@solid-chat-csc207.com",
                "basic");

        repository.createUser("test_receiver", "123456", "test@solid-chat-csc207.com",
                "basic");

        // 2. Create chats (same ID but two copies -- one for each user)
        Chat newChat = new PrivateChat("test_receiver", "1", "test_receiver");

        repository.addChatToUser("james", newChat);

        Chat newChat2 = new PrivateChat("james", "1", "james");

        repository.addChatToUser("test_receiver", newChat2);



        MsgFactory msgFactory = new MsgFactory("text");  // create text message

        ConvHistPresenter presenter = new ConvHistPresenter() {
            @Override
            public ConvHistResponseModel prepareSuccessView(ConvHistResponseModel conversationHistory) {
                Message msg = conversationHistory.getConversationHistory().get(0);

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