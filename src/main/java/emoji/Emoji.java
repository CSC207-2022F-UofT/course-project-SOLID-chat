package emoji;

public class Emoji {
    private String shortname;
    private  String unicode;
    private String hex;
    private int emojiOrder;
    private String category;

    public String getShortname(){
        return shortname
    }
    public void setShortname(String shortname){
        this.shortname = shortname;
    }
    public String getUnicode(){
        return unicode;
    }

    public void setUnicode(String unicode){
        this.unicode = unicode;
    }

    public int getEmojiOrder(){
        return emojiOrder;
    }

    public void setEmojiOrder(int emojiOrder) {
        this.emojiOrder = emojiOrder;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString(){
        return "Emoji: [shortname:" + shortname + ", unicode:" + unicode + ", hex: " + hex +
                ", emojiOrder: " + emojiOrder + ", category: " + category + "]";
    }
}
