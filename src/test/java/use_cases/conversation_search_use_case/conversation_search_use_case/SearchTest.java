package use_cases.conversation_search_use_case.conversation_search_use_case;

import entities.chat.Chat;
import entities.chat.PrivateChat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.conversation_search_use_case.chat.SearchUseCase;
import entities.message.Message;
import entities.message.TextMessage;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class SearchTest{
    @Test
    public void Search_word_one(){ //test for having only one message for search return
        Chat a = new PrivateChat("Emma", "001", "John");
        SearchUseCase b = new SearchUseCase(a);
        TextMessage testMessage = new TextMessage("James",
                "First test message!", LocalDateTime.now(), "x");
        a.addToConvHist(testMessage);
        ArrayList<Message> test = new ArrayList<Message>(Arrays.asList(new TextMessage("James",
                "First test message!", LocalDateTime.now(), "x")));
        Assertions.assertEquals(b.SearchBykeyword("test").get(0).getMsgContent(), "First test message!");
    }

    @Test
    public void Search_word_two(){ //test for not find, should return empty
        Chat a = new PrivateChat("Emma", "001", "John");
        SearchUseCase b = new SearchUseCase(a);
        TextMessage testMessage = new TextMessage("James",
                "First test message!", LocalDateTime.now(), "x");
        a.addToConvHist(testMessage);
        ArrayList<Message> test = new ArrayList<Message>(Arrays.asList(new TextMessage("James",
                "First test message!", LocalDateTime.now(), "x")));
        Assertions.assertEquals(b.SearchBykeyword("Emma"), new ArrayList<>());
    }

}