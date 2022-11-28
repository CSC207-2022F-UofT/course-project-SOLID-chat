package chat.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Emoji Selector
 */
public class EmosWindow extends JWindow {
    private static final long serialVersionUID = 1L;
    public static final String FACE_IMAGE_DIR = "defaultemoji/";
    public static final String GIF_SUB = ".gif";

    GridLayout gridLayout1 = new GridLayout(7,15);
    JLabel[] ico = new JLabel[105]; /*PutEmoji*/
    int i;
    ChatFrame owner;

    public EmosWindow(ChatFrame owner){
        super(owner);
        this.owner = owner;
        try{
            init();
            this.setAlwaysOnTop(true);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }

    private void init() throws Exception{
        this.setPreferredSize(new Dimension(28*15, 28*7));
        JPanel emoji = new JPanel();
        emoji.setOpaque(true);
        this.setLayout((LayoutManager) emoji);
        emoji.setLayout(gridLayout1);
        emoji.setBackground(SystemColor.text);
        String fileName = "";
        for (i=0; i < ico.length; i++){
            fileName = FACE_IMAGE_DIR + i + GIF_SUB; /*Change Emoji Address*/
            ico[i] = new JLabel(new ChatEmo(EmosWindow.class.getResource(fileName), i), SwingConstants.CENTER);
            ico[i].setBorder(BorderFactory.createLineBorder(new Color(255,255,255), 1));
            ico[i].setToolTipText(i + "");
            ico[i].addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getButton() == 1){
                        JLabel cubl = (JLabel) (e.getSource());
                        ChatEmo cupic = (ChatEmo) (cubl.getIcon());
                        owner.insertSendEmo(cupic);
                        cubl.setBorder(BorderFactory.createLineBorder(new Color(225,225,225),1));
                        getObj().dispose();
                    }
                }

                @Override
                public void mouseEntered(MouseEvent e){
                    ((JLabel) e.getSource()).setBorder(BorderFactory.createLineBorder(Color.BLUE));
                }

                @Override
                public void mouseExited(MouseEvent e){
                    ((JLabel) e.getSource()).setBorder(BorderFactory.createLineBorder(new Color(225,225,225),1));
                }
            });
            emoji.add(ico[i]);
        }
        emoji.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseExited(MouseEvent e){
                getObj().dispose();
            }
        });
    }

    @Override
    public void setVisible(boolean show) {
        if (show) {
            determineAndSetLocation();
        }
        super.setVisible(show);
    }

    private void determineAndSetLocation() {
        Point loc = owner.getEmoBtn().getLocationOnScreen();/*Relative Position*/
        setBounds(loc.x - getPreferredSize().width / 3, loc.y - getPreferredSize().height,
                getPreferredSize().width, getPreferredSize().height);
    }

    private JWindow getObj() {
        return this;
    }
}
