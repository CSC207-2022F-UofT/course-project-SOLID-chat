package main.java.emoji_manager.model;

/**
 * EmoInfo
 */
public class EmoInfo {
    /* Emo Info*/
    int pos;
    String val;

    public EmoInfo(int pos, String val) {
        this.pos = pos;
        this.val = val;
    }

    public int getPos() {
        return pos;
    }

    public String getVal() {
        return val;
    }
}
