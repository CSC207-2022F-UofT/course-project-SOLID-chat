package use_cases.conversation_search_use_case.chat;

import entities.chat.Chat;
import entities.chat.PrivateChat;
import entities.message.*;
import org.w3c.dom.Text;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
//try to push

public class SearchUseCase implements SearchInputBoundary {
    private final Chat c;
    private int size;

    private Message temp;

    public ArrayList<TextMessage> Found = new ArrayList<>();

    /**
     * / The "output" of this use case.
     */
    // Note: This could also be a fully-fledged class if we need to return
    // information to the controller.


    public SearchUseCase(Chat c) {
        this.c = c;
        this.size= c.getConvHist().size();
    }


    public ArrayList<TextMessage>  SearchBykeyword(String word) {
        System.out.println(c.getConvHist().size());
        this.size = c.getConvHist().size();
        for(int i=0; i<size; i++){
            temp = c.getConvHist().get(i);
//            System.out.println("2"+temp);
            if(temp instanceof TextMessage){
//                if(((TextMessage) temp).getMsgContent().indexOf(word) != -1) {
//                    Found.add(temp);
//                }
                if(((TextMessage) temp).getMsgContent().indexOf(word) != -1){
                    System.out.println(((TextMessage) temp).getMsgContent());
                    Found.add((TextMessage) temp);

                }
            }
        }
        return Found;
    }

    public ArrayList<TextMessage> SearchBytime(Chat c, LocalDateTime time){
        for(int i=0; i<size; i++) {
            temp = c.getConvHist().get(i);
            if (temp instanceof TextMessage){
                if (temp.getTimestamp() == time) {
                    Found.add((TextMessage) temp);
                }
            }
        }
        return Found;
    }

    public Message SearchByNewest(ArrayList<TextMessage> ar){
        if(ar.isEmpty()){
            return null;
        }

        int ar_size = ar.size();
        TextMessage greater = ar.get(0);
        for(int i=1; i<ar_size; i++){
            if((greater.getTimestamp()).compareTo(ar.get(i).getTimestamp()) < 0){
                greater = ar.get(i);
            }
        }
        return greater;
    }

    public static void main(String[] args){

        Chat a = new PrivateChat("Emma", "001", "John");
        SearchUseCase b = new SearchUseCase(a);
//        ArrayList<Message> test = new ArrayList<Message>(Arrays.asList(new TextMessage("James",
//                "First test message!", LocalDateTime.now(), "x")));
        TextMessage testMessage = new TextMessage("James",
                "First test message!", LocalDateTime.now(), "x");
        a.addToConvHist(testMessage);
//
        b.SearchBykeyword("test");
        System.out.println(1);

    }

}
