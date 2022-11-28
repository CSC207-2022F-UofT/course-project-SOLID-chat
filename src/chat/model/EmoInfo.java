package chat.model;

/**
 * Emoji Information
 */
public class EmoInfo {
    /* Picture Information*/
    int pos;
    String val;

    public EmoInfo(int pos, String val) {
        this.pos = pos;
        this.val = val;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
