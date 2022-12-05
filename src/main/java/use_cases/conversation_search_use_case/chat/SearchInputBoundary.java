package use_cases.conversation_search_use_case.chat;

import entities.chat.Chat;
import entities.message.Message;

import java.time.LocalDateTime;
import java.util.ArrayList;
import entities.message.TextMessage;


/**
 * The input boundary for the login use case.
 */
// Note: The interface that the SearchUseCase implements
// It specifies what the input (arguments) and output (return type) are.

public interface SearchInputBoundary {
    ArrayList<TextMessage> SearchBykeyword(String word);

    ArrayList<TextMessage> SearchBytime(String input);

    TextMessage  SearchByNewest(ArrayList<TextMessage> ar);
}
