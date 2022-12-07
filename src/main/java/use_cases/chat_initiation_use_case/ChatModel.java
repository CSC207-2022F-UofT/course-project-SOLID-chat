package use_cases.chat_initiation_use_case;


//Use case layer chat-Initiation .

/**
 * This class is <DS> similar to   ChatRequestModel class of Professor Paul LOGIN example.
 * It contains the Recipientusername. This class will be used in ChatController class to set the Recipient username typed in The chatUI and also used in the input of  ChatInputBoundry Interface to connect the Controller to the
 * ChatInteractor class indirectly.
 *-
 * use the Dependency inversion following the architecture..
 *
 */

public class ChatModel {

    /**
     * recipient username of CHatModel
     */

    private final String recipientusername;

    /**
     * Construct a new ChatModel
     * @param recipientusername is the username of the Rcipient username.
     */

    public ChatModel (String recipientusername){
        this.recipientusername = recipientusername;
    }


    /**
     * A getter for the Recipient-username , late rused in the ChatInteract class
     * @return  String
     */

    public String getRecipientusername() {
        return recipientusername;
    }
}
