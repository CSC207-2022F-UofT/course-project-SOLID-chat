package chatlinitation;



import entities.PrivateChat;

/**
 * Chatinteractor  connects our ChatView UI to our Entities.
 * It provide data to the view, so that view can put that data on the screen.
 * this class contain Privatchat and methods to update the Private chat.
 */

public class ChatInteractor{

    PrivateChat privatechat;


    // constructor containing the  private chat
    public ChatInteractor(PrivateChat privatechat) {
        this.privatechat = privatechat;
    }


    //Update the Recipientusername when the user type in the username text field and click add button.
    public void setRecipientUsername(String recipientUsername) {
        this.privatechat.setRecipientUsername(recipientUsername) ;
    }


    // Update the message history when the type in put in message txtfieled and click send button.
    public void setMessage(String content) {
        MsgFactory msgfactory = new MsgFactory("text");
        privatechat.addtoconvHist(msgfactory.createMsg(privatechat.getSendertUsername(), content));
    }


}
