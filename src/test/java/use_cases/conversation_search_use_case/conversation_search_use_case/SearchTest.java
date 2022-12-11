package use_cases.conversation_search_use_case.conversation_search_use_case;

import entities.chat.Chat;
import entities.chat.PrivateChat;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import use_cases.conversation_search_use_case.chat.SearchUseCase;
import entities.message.Message;
import entities.message.TextMessage;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void Search_word_three(){ //test for having more than one message satifies
        Chat a = new PrivateChat("Emma", "001", "John");
        SearchUseCase b = new SearchUseCase(a);
        TextMessage testMessage1 = new TextMessage("James",
                "First test message!", LocalDateTime.now(), "x");
        TextMessage testMessage2 = new TextMessage("Emma",
                "Second test message!", LocalDateTime.now(), "x");
        a.addToConvHist(testMessage1);
        a.addToConvHist(testMessage2);
        ArrayList<TextMessage> actuala = new ArrayList<>();
        actuala.add(testMessage1);
        actuala.add(testMessage2);

        Assertions.assertEquals(b.SearchBykeyword("test"), actuala);
    }

    @Test
    public void Search_time_one(){ //test for search by time with two messages, only one qualify
        Chat a = new PrivateChat("Emma", "001", "John");
        SearchUseCase b = new SearchUseCase(a);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        TextMessage testMessage1 = new TextMessage("James",
                "First test message!", LocalDateTime.parse("2022-09-25 10:30", formatter), "3");
        TextMessage testMessage2 = new TextMessage("Emma",
                "Second test message!", LocalDateTime.parse("2022-07-20 08:30", formatter), "x");
        a.addToConvHist(testMessage1);
        a.addToConvHist(testMessage2);
        ArrayList<TextMessage> actuala = new ArrayList<>();
        actuala.add(testMessage2);
        Assertions.assertEquals(b.SearchBytime("2022-07-20 08:30"), actuala);
    }

    @Test
    public void Search_time_two(){ //test for having more than one message satifies
        Chat a = new PrivateChat("Emma", "001", "John");
        SearchUseCase b = new SearchUseCase(a);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        ArrayList<TextMessage> actuala = new ArrayList<>();
        Assertions.assertEquals(b.SearchBytime("2022-07-20 08:30"), actuala);
    }

    @Test
    public void Search_time_three(){ //test for search by time with three messages, two qualify
        Chat a = new PrivateChat("Emma", "001", "John");
        SearchUseCase b = new SearchUseCase(a);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        TextMessage testMessage1 = new TextMessage("James",
                "First test message!", LocalDateTime.parse("2022-09-25 10:30", formatter), "3");
        TextMessage testMessage2 = new TextMessage("Emma",
                "Second test message!", LocalDateTime.parse("2022-07-20 08:30", formatter), "x");
        TextMessage testMessage3 = new TextMessage("John",
                "Third test message!", LocalDateTime.parse("2022-07-20 08:30", formatter), "3");
        a.addToConvHist(testMessage1);
        a.addToConvHist(testMessage2);
        a.addToConvHist(testMessage3);
        ArrayList<TextMessage> actuala = new ArrayList<>();
        actuala.add(testMessage2);
        actuala.add(testMessage3);
        Assertions.assertEquals(b.SearchBytime("2022-07-20 08:30"), actuala);
    }

    @Test
    public void Search_newest_test(){ //test for having more than one message satifies
        Chat a = new PrivateChat("Emma", "001", "John");
        SearchUseCase b = new SearchUseCase(a);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        TextMessage testMessage1 = new TextMessage("James",
                "First test message!",  LocalDateTime.parse("2022-09-25 10:30", formatter), "x");
        TextMessage testMessage2 = new TextMessage("Emma",
                "Second test message!", LocalDateTime.now(), "x");
        a.addToConvHist(testMessage1);
        a.addToConvHist(testMessage2);
        ArrayList<TextMessage> actuala = new ArrayList<>();
        actuala.add(testMessage1);
        actuala.add(testMessage2);

        Assertions.assertEquals(b.SearchByNewest(b.SearchBykeyword("test")), testMessage2);
    }
    @Test
    public void Search_keyword_multiple_results() {
// Test for searching by keyword with multiple messages that match the keyword
        Chat a = new PrivateChat("Emma", "001", "John");
        SearchUseCase b = new SearchUseCase(a);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        TextMessage testMessage1 = new TextMessage("James",
                "First test message!", LocalDateTime.parse("2022-09-25 10:30", formatter), "x");
        TextMessage testMessage2 = new TextMessage("Emma",
                "Second test message!", LocalDateTime.parse("2022-09-26 12:30", formatter), "x");
        TextMessage testMessage3 = new TextMessage("John",
                "Third test message!", LocalDateTime.parse("2022-09-27 14:30", formatter), "x");
        a.addToConvHist(testMessage1);
        a.addToConvHist(testMessage2);
        a.addToConvHist(testMessage3);
        ArrayList<TextMessage> expectedResults = new ArrayList<>();
        expectedResults.add(testMessage1);
        expectedResults.add(testMessage2);
        expectedResults.add(testMessage3);

        Assertions.assertEquals(b.SearchBykeyword("test"), expectedResults);
    }

    @Test
    public void searchByNewestTest() {
        Chat chat = new PrivateChat("Emma", "001", "John");
        SearchUseCase search = new SearchUseCase(chat);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Create a list of messages with different timestamps
        List<TextMessage> messages = Arrays.asList(
                new TextMessage("James", "First test message!", LocalDateTime.parse("2022-09-25 10:30", formatter), "x"),
                new TextMessage("Emma", "Second test message!", LocalDateTime.parse("2022-07-20 08:30", formatter), "x"),
                new TextMessage("John", "Third test message!", LocalDateTime.parse("2022-11-01 15:00", formatter), "x")
        );
        // Add the messages to the chat history
        messages.forEach(message -> chat.addToConvHist(message));

        // Search for messages containing the keyword "test"
        ArrayList<TextMessage> searchResults = search.SearchBykeyword("test");

        // Assert that the newest message in the search results is the third message
        Assertions.assertEquals(search.SearchByNewest(searchResults), messages.get(2));
    }





}
