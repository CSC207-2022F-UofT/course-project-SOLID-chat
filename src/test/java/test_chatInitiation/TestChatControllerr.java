package test_chatInitiation;
import entities.chat.CommonPrivatechat;
import entities.chat.PrivateChatFactory;
import org.junit.jupiter.api.Test;
import screens.chat_screen.ChatController;
import use_cases.chat_initiation_use_case.ChatInputBoundry;
import use_cases.chat_initiation_use_case.ChatInteractor;
import use_cases.chat_initiation_use_case.ChatModel;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestChatControllerr {


    /**
     * checking the add button and check  if the newprivate chat objected have changed to the Recipient
     * username we type in UI . Here I user "amy" which already exist in our database.
     */

        @Test
        public void checkaddbutton() {


            PrivateChatFactory chatFactory = new CommonPrivatechat();
            ChatInputBoundry Interactor = new ChatInteractor(chatFactory);
            ChatController controller = new ChatController(Interactor, "parmism");
            controller.create(new ChatModel("amy").getRecipientusername());
            assertEquals("amy",controller.getNewprivatechat().getRecipientUsername());

        }



    }





