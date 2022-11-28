package chat.component;

import chat.model.EmoInfo;

import javax.swing.*;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;



/**
 *
 * @author Bin Wang
 * @version 2.0 by Java Swing
 */
public class ChatFrame extends JFrame implements MouseListener {
    private static final long serialVersionUID = 1L;
    public final int F_WIDTH = 550;
    public final int F_HEIGHT = 550;


    private JComboBox fontName = null, fontSize = null, fontColor = null;
    private JButton b_emo, b_remove = null;
    private JButton btnSend;

    private JTextPane jpChat;

    private JTextPane jpMsg;

    private EmosWindow picWindow;

    private List<EmoInfo> myEmoInfo = new LinkedList<>();
    private List<EmoInfo> receiveEmoInfo = new LinkedList<>();

    private StyledDocument docChat = null;
    private StyledDocument docMsg = null;

    /**
     * init Windows
     */
    private void init() {
        setLayout(new BorderLayout());
        /*this.setUndecorated(true);*/
        /*		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
         */
        setSize(F_WIDTH, F_HEIGHT);
        this.setMinimumSize(new Dimension(F_WIDTH, F_HEIGHT));
        this.getContentPane().setBackground(Color.GRAY);
        setResizable(false);
        setLocationRelativeTo(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }

        });
        this.addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                ChatFrame.this.picWindow.dispose();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                ChatFrame.this.picWindow.dispose();
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                ChatFrame.this.picWindow.dispose();
            }

        });
        /*Windows Front*/
        setAlwaysOnTop(true);

        /*add MouseListener*/
        btnSend.addMouseListener(this);
        Box box_1 = Box.createHorizontalBox();
        box_1.add(b_emo);

        JPanel paneLeftSouth = new JPanel();
        paneLeftSouth.add(box_1, BorderLayout.NORTH);

        b_emo = new JButton("Emoji");
        b_emo.setFocusable(false);
        picWindow = new EmosWindow(this);
        b_emo.addMouseListener(this);
        box_1.add(b_emo);
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        picWindow.setVisible(false);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (getY() <= 0) {
            setLocation(getX(), 0);
        }
        if (e.getButton() != 1)
            return; /*Not Left Click*/

        JComponent source = (JComponent) e.getSource();
        /*Release Mouse, then Events Happen */
        if (e.getX() >= 0 && e.getX() <= source.getWidth() && e.getY() >= 0
                && e.getY() <= source.getHeight()) {
            if (source == this.b_emo) {
                picWindow.setVisible(true);
            }

        }


        }




    /**
     * insert emoji
     * @param imgIc
     */
    public void insertSendEmo(ImageIcon imgIc) {
        //jpMsg.setCaretPosition(docChat.getLength()); // set insert position
        jpMsg.insertIcon(imgIc); // insert emoji
        System.out.print(imgIc.toString());
        //insert(new FontAttrib()); // newline
    }

    /*
    * rebuild the information of received emoji
     */
    public void receivedEmoInfo(String picInfos) {
        String[] infos = picInfos.split("[+]");
        for (int i = 0; i < infos.length; i++) {
            String[] tem = infos[i].split("&");
            if (tem.length == 2) {
                EmoInfo pic = new EmoInfo(Integer.parseInt(tem[0]), tem[1]);
                receiveEmoInfo.add(pic);
            }
        }
    }

    /**
     * rebuild the information of the emoji
     * @return after rebuild, the format of information as   position| number + position| number+....
     */
    private String buildEmoInfo(){
        StringBuilder sb = new StringBuilder("");
        //iterate jtextpane to find emoji information and package to specified format
        for (int i = 0; i < this.jpMsg.getText().length(); i++) {
            if (docMsg.getCharacterElement(i).getName().equals("icon")) {
                //Chatemo = (Chatemo)
                Icon icon = StyleConstants.getIcon(jpMsg.getStyledDocument().getCharacterElement(i).getAttributes());
                ChatEmo cuemo = (ChatEmo) icon;
                EmoInfo emoInfo = new EmoInfo(i, cuemo.getIm() + "");
                myEmoInfo.add(emoInfo);
                sb.append(i).append("&").append(cuemo.getIm()).append("+");
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
        //return null;
    }

    /**
     * insert Emoji
     */
    int pos1;
    private void insertEmo(){
        if(this.receiveEmoInfo.size() == 0){
            return;
        }else{
            for (int i = 0; i < receiveEmoInfo.size(); i++) {
                EmoInfo pic = receiveEmoInfo.get(i);
                String fileName;
                jpChat.setCaretPosition(pos1 + pic.getPos()); /*insert position*/
                fileName = "defaultemoji/" + pic.getVal() + ".gif";/*change emoji address*/
                jpChat.insertIcon(new ImageIcon(EmosWindow.class.getResource(fileName))); /*insert Emoji*/
                /*					jpChat.updateUI();*/
            }
            receiveEmoInfo.clear();
        }
        jpChat.setCaretPosition(docChat.getLength()); /*set scroll down*/
        //insert(new FontAttrib()); /*newline*/
    }

    public JButton getEmoBtn () {
        return b_emo;
    }
}
