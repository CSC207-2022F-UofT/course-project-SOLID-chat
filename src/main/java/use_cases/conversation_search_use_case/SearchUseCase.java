package tutorial;

import java.time.LocalDateTime;
import java.util.ArrayList;
//try to push

public class SearchUseCase implements SearchInputBoundary {
    private final Chat c;
    private int size;

    private Message temp;

    protected ArrayList<Message> Found;

    /**
     * / The "output" of this use case.
     */
    // Note: This could also be a fully-fledged class if we need to return
    // information to the controller.


    public SearchUseCase(Chat c) {
        this.c = c;
        this.size= c.convHist.size();
    }


    public ArrayList<Message>  SearchBykeyword(Chat c, String word) {
        for(int i=0; i<size; i++){
            temp = c.convHist.get(i);
            if(temp.getMsgContent().indexOf(word) != -1){
                Found.add(temp);
            }
        }
        return Found;
    }

    public ArrayList<Message> SearchBytime(Chat c, LocalDateTime time){
        for(int i=0; i<size; i++){
            temp = c.convHist.get(i);
            if(temp.getTimestamp() == time){
                Found.add(temp);
            }
        }
        return Found;
    }

    public Message SearchByNewest(ArrayList<Message> ar){
        if(ar.isEmpty()){
            return null;
        }

        int ar_size = ar.size();
        Message greater = ar.get(0);
        for(int i=1; i<ar_size; i++){
            if((greater.getTimestamp()).compareTo(ar.get(i).getTimestamp()) < 0){
                greater = ar.get(i);
            }
        }
        return greater;
    }


}
