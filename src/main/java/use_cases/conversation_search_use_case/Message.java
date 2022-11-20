package tutorial;
import java.time.LocalDateTime;
/**
 * Copied from Branch Conversation History
 * **/
public abstract class Message {
        /**
         * ID of message sender (UUID)
         */
        private final String senderID;
        /**
         * Time message was sent
         */
        private final LocalDateTime timestamp;
        /**
         * ID of message (UUID)
         */
        private final String msgID;


        /**
         * Construct a new message
         * @param senderID ID of sender
         * @param timestamp time message was sent
         * @param msgID ID of message
         */
        public Message(String senderID, LocalDateTime timestamp, String msgID) {
            this.senderID = senderID;
            this.timestamp = timestamp;
            this.msgID = msgID;
        }

        /**
         * Gets ID of sender
         * @return ID of sender
         */
        public String getSenderID() {
            return senderID;
        }

        /**
         * Gets message timestamp
         * @return message timestamp
         */
        public LocalDateTime getTimestamp() {
            return timestamp;
        }

        /**
         * Gets ID of message
         * @return ID of message
         */
        public String getMsgID() {
            return msgID;
        }

        //Implemented this method from James' code -Emma
        public abstract String getMsgContent();


    }
