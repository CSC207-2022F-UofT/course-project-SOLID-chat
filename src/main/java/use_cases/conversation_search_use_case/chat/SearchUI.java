package use_cases.conversation_search_use_case.chat;
import entities.chat.Chat;
import entities.chat.PrivateChat;
import entities.message.TextMessage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class SearchUI implements ActionListener{

    private Chat a = new PrivateChat("Emma", "001", "John");

    private boolean first=true;

    private SearchInputBoundary b;
    private JLabel label, title, instruction, note;

    private JFrame frame;

    private JPanel panel;

    private JButton button, button2;

    private JTextField input;

    private String s;

    private ArrayList<TextMessage> result = new ArrayList<>();

    private JLabel[] labels;
    public SearchUI(Chat a){
        System.out.println(55555);
        this.a = a;
        this.b = new SearchUseCase(a);
//        a=new Chat();
//        a = new PrivateChat("Emma", "001", "John");
        System.out.print(b);
        System.out.println(11111);
//        demo();
        System.out.println(222222);
        frame= new JFrame();
        button = new JButton("Search this word"); //button
        button2 = new JButton("Search this time");
        note = new JLabel("Time must be in the format of YYYY-MM-DD hh:mm, e.g. 2022-08-03 12:25");
        input = new JTextField();
        button.addActionListener(this);
        button2.addActionListener(this);
        title = new JLabel("Search messages using a keyword or sent time...", 0);
        instruction = new JLabel("Please enter the word/time you want to search", 0);
        label = new JLabel("Results: ", 0);


        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,30,30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(title);
        panel.add(instruction);
        panel.add(input);
        panel.add(note);
        panel.add(button); //button
        panel.add(button2);
        panel.add(label);


        frame.add(panel,BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Search Messages in Chat");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            if(!first){
                clear();
            }else{
                first=false;
            }
            s=input.getText();
            result = b.SearchBykeyword(s);
            output();
        }

        else if(e.getSource() == button2){
            if(!first){
                clear();
            }else{
                first=false;
            }
            s=input.getText();
            result = b.SearchBytime(s);
            output();
        }
    }

    public void demo(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        TextMessage testMessage1 = new TextMessage("James",
                "First test message!", LocalDateTime.parse("2022-09-25 10:30", formatter), "3");
        TextMessage testMessage2 = new TextMessage("Emma",
                "Second test message!", LocalDateTime.parse("2022-07-20 08:30", formatter), "x");
        a.addToConvHist(testMessage1);
        a.addToConvHist(testMessage2);
    }

    public void clear(){
        for(int i=0; i< labels.length; i++){
            panel.remove(labels[i]);
            panel.validate();
            panel.repaint();
        }
    }

    public void output(){
        labels = new JLabel[result.size()];
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i).getMsgContent());
            labels[i] = new JLabel(result.get(i).getSenderID() + " sent: " + result.get(i).getMsgContent()
                    +" at " + result.get(i).getTimestamp(), 0);
            panel.add(labels[i]);
        }
        frame.pack();

    }

    public void setA(Chat b){
        this.a = b;
    }

    public static void main(String[] args){
        Chat a= new PrivateChat("Amy", "001", "Bin");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        TextMessage testMessage1 = new TextMessage("James",
                "Hi, my name is", LocalDateTime.parse("2022-09-25 10:30", formatter), "3");
        TextMessage testMessage2 = new TextMessage("Emma",
                "Hi, my name is two!", LocalDateTime.parse("2022-07-20 08:30", formatter), "x");
        a.addToConvHist(testMessage1);
        a.addToConvHist(testMessage2);
        //demo
        SearchUI c = new SearchUI(a);


    }
}
