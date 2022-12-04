package test_chatInitiation;

import data_access.UserDatabase;
import entities.chat.CommonPrivatechat;
import entities.chat.PrivateChatFactory;
import entities.user_entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import screens.chat_screen.ChatController;
import screens.chat_screen.ChatView;
import use_cases.chat_initiation_use_case.ChatInputBoundry;
import use_cases.chat_initiation_use_case.ChatInteractor;
import use_cases.chat_initiation_use_case.ChatModel;

import java.io.File;

public class TestChatControllerr {




//
//        @Test
//        public void passwordChange() {
//            UserDatabase db = new UserDatabase(new File("user_accounts"));
//            System.out.println(db.UserExists("Nasim"));
//            User Nasim = db.getUser("Nasim");
//            Nasim.login();
//
//            PrivateChatFactory chatFactory = new CommonPrivatechat();
//            ChatInputBoundry Interactor = new ChatInteractor(chatFactory);
//            ChatController controller = new ChatController(Interactor, "current username");
////            new ChatView(controller,true);
//
//            ChatModel chatmodel = new ChatModel("Nasim");
//            String Controller_username = String.valueOf(controller.create(chatmodel.getRecipientusername()));
//
//            Assertions.assertEquals("Nasim", Controller_username);
//
//
//
//        }

    }

