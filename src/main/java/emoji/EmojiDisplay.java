package emoji;

import java.util.Queue;


import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class EmojiDisplay {
    public static Node[] createEmojiAndTextNode(String input) {
        Queue<Object> queue = EmojiHandle.getInstance().toEmojiAndText(input);
        Node[] nodes = new Node[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            Object ob = queue.poll();
            if (ob instanceof String) {
                String text = (String) ob;
                nodes[i++] = createTextNode(text);
            } else if (ob instanceof Emoji) {
                Emoji emoji = (Emoji) ob;
                nodes[i++] = createEmojiNode(emoji, 24, 10);
            }
        }
        return nodes;
    }

    public static Node createEmojiNode(Emoji emoji, int size, int pad) {
        StackPane stackPane = new StackPane();
        stackPane.setMaxSize(size, size);
        stackPane.setPrefSize(size, size);
        stackPane.setMinSize(size, size);
        stackPane.setPadding(new Insets(pad));
        ImageView imageView = new ImageView();
        imageView.setFitWidth(size);
        imageView.setFitHeight(size);
        imageView.setImage(ImageCache.getInstance().getImage(getEmojiImagePath(emoji.getHex())));
        stackPane.getChildren().add(imageView);

        return stackPane;
    }

    private static Node createTextNode(String text) {
        Text textNode = new Text(text);
        textNode.setFont(Font.font("Arial", 15));
        return textNode;
    }

    private static String getEmojiImagePath(String hexStr) {
        return "emoji/png_40/" + hexStr + ".png";
    }
}