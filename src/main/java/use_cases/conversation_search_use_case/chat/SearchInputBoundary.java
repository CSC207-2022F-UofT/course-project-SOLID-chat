package use_cases.conversation_search_use_case;

import java.time.LocalDateTime;
import java.util.ArrayList;


/**
 * The input boundary for the login use case.
 */
// Note: The interface that the SearchUseCase implements
// It specifies what the input (arguments) and output (return type) are.

public interface SearchInputBoundary {
    ArrayList<Message> SearchBykeyword(Chat c, String word);

    ArrayList<Message> SearchBytime(Chat c, LocalDateTime time);

    Message  SearchByNewest(ArrayList<Message> ar);
}
