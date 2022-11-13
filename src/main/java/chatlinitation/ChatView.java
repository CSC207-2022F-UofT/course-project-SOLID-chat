package chatlinitation;


import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * ChatView is our UI for Private chat.It Containe a chatframe .At the top of the frame
 * there is a text file in which we type userB's username, and  chat frame will change into
 * "userB'S username." AT the bottom of the frame, there is another text field to type a message and
 * send button to send the message
 *
 * In the middle of the frame I put andJTextArea for the chat History.
 *
 */

//todo: we should complete the chatHistory in this class.




class ChatView extends JFrame implements  ActionListener{

    private ChatViewmodel viewmodel;
    private JFrame frame ;
    private JButton addbutton;
    private JButton send;
    private JLabel l;
    private JLabel label;
    private JTextField usernametextfield;
    private JTextField messagetextfield;
    private JMenuBar menubar;
    private JPanel panel;
    private JTextArea textArea;


    //this is constructor od this class
    public ChatView(){
        viewmodel = new ChatViewmodel();
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



        //create a new "panel" and new "label" and a text flied ."label"a nd "txtfield1"
        panel = new JPanel();
        label = new JLabel("Enter text here");
        messagetextfield = new JTextField(20);


        //adding "send" button
        send = new JButton("Send");
        send.setFocusable(false);


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
        panel.add(send);



        // set the text part in the middle
        textArea = new JTextArea();


        //Locating the Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, menubar);
        frame.getContentPane().add(BorderLayout.CENTER, textArea);

        // set the frame visibile
        frame.setVisible(true);


    }


// we implement the Actionlistener class so we should implement this method.
// this method create an action for our buttons
//we use our viewmodel attribute inn this method.
    @Override
    public void actionPerformed(ActionEvent e) {

        // STEP1: action for the  "add button" at the top of frame.
        // goal : we want to write user'sB username  in text filed and click "add buttom" to change our chat frame title
        // to user'sB username.
        //  first we convert textfield input to String  and set the frame title to that input.


        if (e.getSource() == addbutton){
            String input = usernametextfield.getText();
            frame.setTitle(input);

            //set the  username in our viewmodel
            viewmodel.setRecipientUsername(input);

            //todo
            //we should find the user with username "input" from list of user's that have logged in and set the
            // user to have the same chat_ID (I did this in the viewmodel)


        }

        // STEP2: action for the "send button".
        // goal : to write a message in txt filed and click "send button"
        // so the message will come in the "txtArea" in middle of frame
        //again we convert the txfield input to a String .


        //first is to convert textfield input to String  and set the frame title to that input.

        if (e.getSource() == send){
            //when the messge type is STring
            String  input = usernametextfield.getText();

            //setting the txtmessage content in our viewmodel
            viewmodel.setMessage(input);

            //todo
            //this is part of the chatHisroy of UI. for now I put a text ( it may needed to change later)

        }
    }


}

