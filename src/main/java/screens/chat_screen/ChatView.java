package screens.chat_screen;


import use_cases.chat_initiation_use_case.ChatInteractor;
import use_cases.chat_initiation_use_case.CheckUsername_Interactor;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * ChatView is our UI for Private chat.It Containe a chatframe .At the top of the frame
 * there is a text file in which we type userB's username, and  chat frame will change into
 * "userB'S username." AT the bottom of the frame, there is another text field to type a message and
 * send button to send the message
 *
 * In the middle of the frame there i sJpanel and Jlabels for the converstaion history.
 *
 */



class ChatView extends JFrame implements  ActionListener{
    //use two Interactors .
    private ChatInteractor chatInteractor;
    private CheckUsername_Interactor checkusername_interactor;

    //Use Jframes, butttons, labels ,textfileds, Jpannels,JMenuBar for UI.
    final JFrame frame ;
    private JButton addbutton;
    final JButton sendbutton;
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

    //isNewchat check we already have a chat with a user
    private boolean isNewchat;




    //this is constructor
    public ChatView( boolean isNewchat){

        this.isNewchat = isNewchat;


        frame= new JFrame();

        // create a menubar  at the top of the frame
        menubar = new JMenuBar();


        // create a label called l , and text field called "txt"
        l = new JLabel("  username");
        usernametextfield = new JTextField(10);
        addbutton = new JButton("add");
        addbutton.setFocusable(false);


        // create two buttom called "addbuttom" and a "groupchat buttom"
        addbutton = new JButton("add");
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


    }


    // create a setup for display of buttons and other component of the frame.
    public void chatdisplay(){

        // set frame size and frame title
        frame.setSize(450, 500);
        frame.setTitle("Chat box");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // adding "addbutton" and "groupchatbutton"  to the menu bar
        menubar.add(l);
        menubar.add(usernametextfield);
        menubar.add(addbutton);



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
        if (isNewchat){
            frame.getContentPane().add(BorderLayout.NORTH, menubar);
        }


        frame.getContentPane().add(BorderLayout.CENTER, conversationHistoryPanel);

        // set the frame visibile
        frame.setVisible(true);

        this.addbutton.addActionListener(this);
        this.sendbutton.addActionListener(this);


    }



    //we implement ActionListener class and should override this method for our button's actions.

    @Override
    public void actionPerformed(ActionEvent e) {

        // STEP1: action for the  "add button" at the top of frame.
        // goal : click on add button will change the chat frame's title to user'sB username(typed in  the textfiled)


        if (e.getSource() == addbutton){
            //  convert textfield input to String and set the frame title to that input is username exists.
            String input = usernametextfield.getText();
            if (checkusername_interactor.checkusername(input)){
                frame.setTitle(input);
            }

            // also set the input -will change the private chat's RecipientUsername .
            chatInteractor.setRecipientUsername(input);

        }


        // STEP2: action for the "send button".
        // goal : to write a message in txt filed and click "send button"
        // so the message will come in the middle  of the frame

        if (e.getSource() == sendbutton){

            //convert the text field input to a String
            String  input = usernametextfield.getText();

            // setting our messge in the chatInteractor- will add this message to conv history.
            chatInteractor.setMessage(input);

            //TODO:this is chatHisroy action.


        }
    }
//    public static void main(String args[]) {
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                ChatView chat = new ChatView(true);
////                chat.getframe().setTitle("AMMY")
//                chat.chatdisplay();
//
//
//                //todo
//                //chat history
//
//
//            }
//        });
//
//    }

}

