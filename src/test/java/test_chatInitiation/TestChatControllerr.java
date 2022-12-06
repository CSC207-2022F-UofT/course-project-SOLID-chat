package test_chatInitiation;

import data_access.UserDatabase;
import entities.chat.CommonPrivatechat;
import entities.chat.PrivateChatFactory;
import org.junit.jupiter.api.Test;
import screens.chat_screen.ChatController;
import use_cases.chat_initiation_use_case.ChatInputBoundry;
import use_cases.chat_initiation_use_case.ChatInteractor;
import use_cases.chat_initiation_use_case.ChatModel;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestChatControllerr {





        @Test
        public void passwordChange() {
//            UserDatabase db = new UserDatabase();
//            System.out.println(db.UserExists("Nasim"));
//            User Nasim = db.getUser("Nasim");

//            for (User user: db.getList()){
//                System.out.println(user.getUsername());
//            }
            PrivateChatFactory chatFactory = new CommonPrivatechat();
            ChatInputBoundry Interactor = new ChatInteractor(chatFactory);
            ChatController controller = new ChatController(Interactor, "nasim");
            controller.create(new ChatModel("amy").getRecipientusername());
            assertEquals("amy",controller.getNewprivatechat().getRecipientUsername());



        }

    }

