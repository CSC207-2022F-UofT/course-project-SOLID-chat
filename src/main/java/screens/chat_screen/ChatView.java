package screens.chat_screen;



import data_access.InMemoryUserDataAccess;
import data_access.UserDatabase;
import entities.chat.*;
import entities.message.*;
import entities.user_entities.User;
import interface_adapters.conversation_history_interface_adapters.*;
import use_cases.conversation_history_use_case.*;
import use_cases.chat_initiation_use_case.*;


import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;



/**
 * ChatView is our UI for Private chat.It Contains a chat frame .At the top of the frame
 * there is a text file in which we type userB's username, and  chat frame  title changes into
 * "userB'S username."  AT the bottom of the frame, there is another text field to type a message and
 * send button to send the message
 *-
 * In the middle of the frame there is Panel and Labels for the conversation history.
 */


//todo: we should complete the chatHistory in this class.




public class ChatView extends JFrame implements ActionListener {
        /**
         * use the Chat controller to pass the Recipient username to the create method of the Controller.
         */
        private final ChatController controller;

        /**
         * Use J frames , buttons , Labels, text fields, Panels and menu-bar for visualizing the UI.
         */

        final JFrame frame;
        final JButton addbutton;
        final JButton sendbutton;

        final JButton searchbutton;

        final JLabel l;
        final JLabel label;
        final JTextField usernametextfield;
        final JTextField messagetextfield;
        final JMenuBar menubar;
        final JPanel panel;
        final JPanel conversationHistoryPanel;

        private JPanel messagePanel;
        private JLabel testMessageHeader;
        private JLabel testMessage;

        /**
         * Using isNeW boolean to check if it is first time user open the chatUI or not.
         * I sto check if the user have already  existing have a chat with user.
         */

        public final boolean isNewchat;

        private String username;
        private String chatID;
        private UserDatabase repository;


        /**
         * Construct a new  ChatView
         *
         * @param controller Controller Chat view
         * @param isNewchat  Boolean if the user have already a chat with my user.
         */

        public ChatView(ChatController controller, boolean isNewchat, String username, String chatID, UserDatabase repository) {
            this.controller = controller;
            this.isNewchat = isNewchat;
            this.username = username;
            this.chatID = chatID;
            this.repository = repository;

            frame = new JFrame();

            // create a menubar  at the top of the frame
            menubar = new JMenuBar();


            // create a label called l , and text field called "txt"
            l = new JLabel("  username");
            usernametextfield = new JTextField(10);


            // create two buttom called "addbuttom" and a "search a message buttom"
            addbutton = new JButton("add");
            searchbutton = new JButton("search a message");
            searchbutton.setFocusable(false);
            addbutton.setFocusable(false);

            // create conversation history-related components
            conversationHistoryPanel = new JPanel();
            conversationHistoryPanel.setLayout(new BoxLayout(conversationHistoryPanel, BoxLayout.Y_AXIS));


            //create a new "panel" and new "label" and a text flied ."label"a nd "txtfield1"
            panel = new JPanel();
            label = new JLabel("Enter text here");
            messagetextfield = new JTextField(20);


            //adding "send" button
            sendbutton = new JButton("Send");
            sendbutton.setFocusable(false);


            // create a setup for display of buttons and other component of the frame.

            // set frame size and frame title
            frame.setSize(450, 500);
            frame.setTitle("Chat box");
            frame.setLocation(587, 100);
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


            // adding "addbutton" and "groupchatbutton"  to the menu bar
            if (isNewchat) {
                menubar.add(l);
                menubar.add(usernametextfield);
                menubar.add(addbutton);
            }

            menubar.add(searchbutton);


            // adding label and textfiled1 to our panel .
            panel.add(label);
            panel.add(messagetextfield);
            panel.add(sendbutton);


            // add content to conversationHistoryPanel
            if (!isNewchat) {
                // TODO 1/3: update to controller's output

                // initialize stuff

//            ArrayList<Message> conversationHistory = convHistController.create();

//            ArrayList<Message> conversationHistory = new ArrayList<Message>(Arrays.asList(new TextMessage("james",
//                    "hi!", LocalDateTime.now(), "x"), new TextMessage("nasim",
//                    "hello!", LocalDateTime.now(), "y")));

//            for (Message message : conversationHistory) {
//
//                // Assumption: message is TextMessage (for now)
//
//                TextMessage textMessage = (TextMessage) message;
//
//                JPanel messagePanel = new JPanel();
//                messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
//                messagePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
//                JLabel messageHeader = new JLabel(textMessage.getSenderID()+ " | " + textMessage.getTimestamp());
//                JLabel messageContent = new JLabel(textMessage.getMsgContent());
//                messagePanel.add(messageHeader);
//                messagePanel.add(messageContent);
//
//                conversationHistoryPanel.add(messagePanel);
//            }
            } else { // ChatView is for new chat: create empty conversation history (directly)
                conversationHistoryPanel.add(new JLabel("To start a conversation, add user(s) by their username."));
            }


            //Locating the Components to the frame.
            frame.getContentPane().add(BorderLayout.SOUTH, panel);
            frame.getContentPane().add(BorderLayout.NORTH, menubar);


            frame.getContentPane().add(BorderLayout.CENTER, conversationHistoryPanel);

            // set the frame visible
            frame.setVisible(true);

            this.addbutton.addActionListener(this);
            this.sendbutton.addActionListener(this);
            this.searchbutton.addActionListener(this);


        }


        /**
         * This class implements the ActionListener and overrides the actionPerformed method.
         * This method checks for actions of our buttons. "add button" for username and
         * "send button" for sending a message.
         * -
         * when a user type a Recipient username and click the add button it checks if the username
         * exists in the data base if yes the frame title will changed to the recipient username .
         * if not a window pups up saying "username doesn't found"
         */


        @Override
        public void actionPerformed(ActionEvent e) {

            // STEP1: action for the  "add button" at the top of frame.

            if (e.getSource() == addbutton) {
                // convert textfield input to String and set the frame title to that input is username exists.

                String input = usernametextfield.getText();
                controller.create(input);
                // checks whether is typed username exist in or not if not open a window with error
                UserDatabase userdatabase = new UserDatabase();
                if (!userdatabase.UserExists(input)) {

                    JOptionPane.showMessageDialog(frame, "username does not found");
                } else {
                    frame.setTitle(input);
                }

                // Update menubar to only have search button (and not button for adding user and related components)
                menubar.remove(2);
                menubar.remove(1);
                menubar.remove(0);
                menubar.revalidate();
                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();
            }


            // STEP2: action for the "send button".

            if (e.getSource() == sendbutton) {
                //when the messge type is STring
                String input = messagetextfield.getText();

                // Initialize objects for MsgSenderInteractor

                MsgFactory msgFactory = new MsgFactory("text");  // create text message

                ConvHistPresenter convHistPresenter = new ConvHistResponseFormatter();

                MsgSenderInputBoundary msgSenderInputBoundary = new MsgSenderInteractor(repository,
                        repository, msgFactory, convHistPresenter);

                // Run interactor and get conversation history
                MsgSenderRequestModel msgSenderRequestModel = new MsgSenderRequestModel(username, input, chatID);
                ConvHistResponseModel convHistResponseModel = msgSenderInputBoundary.create(msgSenderRequestModel);

                ArrayList<Message> convHist = (ArrayList<Message>) convHistResponseModel.getConversationHistory();

                // Add latest message to conversation history and display conv hist

                // Assumption: message is TextMessage (for now)

                TextMessage textMessage = (TextMessage) convHist.get(convHist.size() - 1);

                JPanel messagePanel = new JPanel();
                messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
                messagePanel.setBorder(new EmptyBorder(10, 10, 10, 10));
                JLabel messageHeader = new JLabel(textMessage.getSenderID() + " | " + textMessage.getTimestamp());
                JLabel messageContent = new JLabel(textMessage.getMsgContent());
                messagePanel.add(messageHeader);
                messagePanel.add(messageContent);

                System.out.println(textMessage.getSenderID() + " | " + textMessage.getTimestamp());
                System.out.println(textMessage.getMsgContent());

                // Message content doesn't work
                // sender username + timestamp does show, but conversationHistoryPanel is not updated on screen

                conversationHistoryPanel.add(messagePanel);

                frame.getContentPane().revalidate();
                frame.getContentPane().repaint();


                // Previous implementation: getting the txtmessage content in our viewmodel
//            chatInteractor.setMessage(input);

            }
            if (e.getSource() == searchbutton) {
                new SearchUI(controller.getNewprivatechat());
            }
        }
//    public static void main(String args[]) {
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                // Setting up the use case (doing it manually here but will be done by user when using program)
//                UserDatabase repository = new UserDatabase();
//
//                // 1. Create users
//                repository.createUser("Nasim", "123456", "nasim@solid-chat-csc207.com",
//                        "basic");
//
//                repository.createUser("test_receiver", "123456", "test@solid-chat-csc207.com",
//                        "basic");
//
//                // 2. Create chats (same ID but two copies -- one for each user)
//                Chat newChat = new PrivateChat("test_receiver", "1", "test_receiver");
//
//                repository.addChatToUser("Nasim", newChat);
//
//                Chat newChat2 = new PrivateChat("Nasim", "1", "Nasim");
//
//                repository.addChatToUser("test_receiver", newChat2);
//
//
//
//                ChatView chat = new ChatView(true, "Nasim", "1", repository);
////                chat.getframe().setTitle("AMMY")
//                chat.chatdisplay();
//
//                chat.addbutton.addActionListener(chat);
//                chat.sendbutton.addActionListener(chat);
//
//                //todo
//                //chat history
//
//
//            }
//        });
//
//    }

        //    public static void main(String[] args) {

//
//        PrivateChatFactory chatFactory = new CommonPrivatechat();
//        ChatInputBoundry Interactor = new ChatInteractor(chatFactory);
//        ChatController controller = new ChatController(Interactor, "parmism");
//
//        controller.getNewprivatechat();
//        new ChatView(controller,true);
//
//        controller.create(new ChatModel("amy").getRecipientusername());
//
//        //new ChatView(controller,true);
////        // find the created privatechat and the username
//        System.out.println(controller.getNewprivatechat().getRecipientUsername());
//
//
//    }


}

