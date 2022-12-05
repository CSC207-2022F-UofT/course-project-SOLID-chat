package test_chatInitiation;

import data_access.UserDatabase;
import entities.chat.Chat;
import entities.chat.CommonPrivatechat;
import entities.chat.PrivateChat;
import entities.chat.PrivateChatFactory;
import entities.user_entities.User;
import interface_adapters.user_search_IA.UserPresenterClass;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import screens.chat_screen.ChatController;
import screens.chat_screen.ChatView;
import test_user_login.TestUserLoginInteractor;
import use_cases.appscreen_use_case.ChatInfo;
import use_cases.chat_initiation_use_case.ChatInputBoundry;
import use_cases.chat_initiation_use_case.ChatInteractor;
import use_cases.chat_initiation_use_case.ChatModel;
import data_access.UserDatabase;
import use_cases.user_login_use_cases.UserLoginInteractor2;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestChatControllerr {


    /**
     * checking the add button and check  if the newprivate chat objected have changed to the Recipient
     * username we type in UI . Here I user "amy" which already exist in our database.
     */

        @Test
        public void checkaddbutton() {

            UserDatabase db = new UserDatabase(new File("tester_file_information"));
            PrivateChatFactory chatFactory = new CommonPrivatechat();
            ChatInputBoundry Interactor = new ChatInteractor(chatFactory);
            ChatController controller = new ChatController(Interactor, "parmism");
            controller.create(new ChatModel("amy").getRecipientusername());
            assertEquals("amy",controller.getNewprivatechat().getRecipientUsername());

        }



    }





