package screens.chat_screen;
import data_access.UserDatabase;
import entities.chat.CommonPrivatechat;
import entities.chat.PrivateChatFactory;
import use_cases.chat_initiation_use_case.ChatInputBoundry;
import use_cases.chat_initiation_use_case.ChatInteractor;
import use_cases.chat_initiation_use_case.ChatModel;
import use_cases.conversation_search_use_case.chat.SearchUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * ChatView is our UI for Private chat.It Contains a chat frame .At the top of the frame
 * there is a text file in which we type userB's username, and  chat frame  title changes into
 * "userB'S username."  AT the bottom of the frame, there is another text field to type a message and
 * send button to send the message
 *-
 * In the middle of the frame there is Panel and Labels for the conversation history.
 */


public class ChatView extends JFrame implements  ActionListener{
    /**
     * use the Chat controller to pass the Recipient username to the create method of the Controller.
     */
    private final ChatController controller;

    /**
     * Use J frames , buttons , Labels, text fields, Panels and menu-bar for visualizing the UI.
     */

    final JFrame frame ;
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
     *Using isNeW boolean to check if it is first time user open the chatUI or not.
     *I sto check if the user have already  existing have a chat with user.
     */

    public final boolean isNewchat;


    /**
     * Construct a new  ChatView
     *
     * @param controller   Controller Chat view
     * @param isNewchat    Boolean if the user have already a chat with my user.
     */

    public ChatView(ChatController controller , boolean isNewchat){
        this.controller = controller;
        this.isNewchat = isNewchat;


        frame= new JFrame();

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
        menubar.add(l);
        menubar.add(usernametextfield);
        menubar.add(addbutton);
        menubar.add(searchbutton);


        // adding label and textfiled1 to our panel .
        panel.add(label);
        panel.add(messagetextfield);
        panel.add(sendbutton);


        // add content to conversationHistoryPanel
        conversationHistoryPanel.setLayout(new BoxLayout(conversationHistoryPanel, BoxLayout.Y_AXIS));

//        messagePanel = new JPanel();
//        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
//        testMessageHeader = new JLabel("Username placeholder | Timestamp placeholder");
//        testMessage = new JLabel("Message placeholder");
//        messagePanel.add(testMessageHeader);
//        messagePanel.add(testMessage);
//
//        conversationHistoryPanel.add(messagePanel);

        JPanel messagePanel1 = new JPanel();
        messagePanel1.setLayout(new BoxLayout(messagePanel1, BoxLayout.Y_AXIS));
        messagePanel1.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel testMessageHeader1 = new JLabel("Username placeholder1 | Timestamp placeholder");
        JLabel testMessage1 = new JLabel("Message placeholder1");
        messagePanel1.add(testMessageHeader1);
        messagePanel1.add(testMessage1);

        JPanel messagePanel2 = new JPanel();
        messagePanel2.setLayout(new BoxLayout(messagePanel2, BoxLayout.Y_AXIS));
        messagePanel2.setBorder(new EmptyBorder(10, 10, 10, 10));
        JLabel testMessageHeader2 = new JLabel("Username placeholder2 | Timestamp placeholder");
        JLabel testMessage2 = new JLabel("Message placeholder2");
        messagePanel2.add(testMessageHeader2);
        messagePanel2.add(testMessage2);

        conversationHistoryPanel.add(messagePanel1);
        conversationHistoryPanel.add(messagePanel2);


        //Locating the Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        if (isNewchat) {
            frame.getContentPane().add(BorderLayout.NORTH, menubar);
        }


        frame.getContentPane().add(BorderLayout.CENTER, conversationHistoryPanel);

        // set the frame visible
        frame.setVisible(true);

        this.addbutton.addActionListener(this);
        this.sendbutton.addActionListener(this);
        this.searchbutton.addActionListener(this);


    }


    /**
     *  This class implements the ActionListener and overrides the actionPerformed method.
     *  This method checks for actions of our buttons. "add button" for username and
     *  "send button" for sending a message.
     *  -
     * when a user type a Recipient username and click the add button it checks if the username
     * exists in the data base if yes the frame title will changed to the recipient username .
     * if not a window pups up saying "username doesn't found"
     */


    @Override
    public void actionPerformed(ActionEvent e) {

        // STEP1: action for the  "add button" at the top of frame.

        if (e.getSource() == addbutton){
            // convert textfield input to String and set the frame title to that input is username exists.

            String input = usernametextfield.getText();
            controller.create(input);
            // checks whether is typed username exist in or not if not open a window with error
            UserDatabase userdatabase = new UserDatabase();
            if (!userdatabase.UserExists(input)){

                JOptionPane.showMessageDialog(frame, "username does not found");
            }else {frame.setTitle(input);}



        }


        // STEP2: action for the "send button".

        if (e.getSource() == sendbutton){

            //TODO:this is chatHistory action.


        }
        if (e.getSource()== searchbutton){
            new SearchUI(controller.getNewprivatechat());
        }

    }


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