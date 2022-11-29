package use_cases.chat_initiation_use_case;

//Use case layer chat-Initiation .

public class ChatModel {

    private final String recipientusername;
    //TODO: maybe messge.

    public ChatModel (String recipientusername){
        this.recipientusername = recipientusername;
    }

    // A getter for the Recipient-username , late rused in the ChatInteract class.

    public String getRecipientusername() {
        return recipientusername;
    }
}
