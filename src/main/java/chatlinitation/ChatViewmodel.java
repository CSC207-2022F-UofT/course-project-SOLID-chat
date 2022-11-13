package chatlinitation;
/**
 * chatviewmodel  connects our ChatView UI to our Entities.
 * It provide data to the view, so that view can put that data on the screen.
 * containing the message content and associated metadata
 * this class contain privatechat, recipeint user and Textmessge.
 */

public class ChatViewmodel {

    PrivateChat privatechat;
    User recipient;
    TextMessage txtmessage;


 // constructor of the viewmodel
    public ChatViewmodel() {
        this.privatechat = privatechat;
        this.recipient=recipient;
        this.txtmessage =  txtmessage;
    }



    // when we click the  addbutton for username.our private chat should update it's Recipientusername.
    public void setRecipientUsername(String recipientUsername) {
        this.privatechat.setrecipientUsername(recipientUsername) ;
    }


    //when  type an input click send button , the input should set the txtmessge content
    //and privatechat should  the txtmessage to conversation.
    public void setMessage(String content) {
        this.txtmessage.setMsgContent(content) ;
        privatechatchat.addtoconvHist(txtmessage);

    }



}