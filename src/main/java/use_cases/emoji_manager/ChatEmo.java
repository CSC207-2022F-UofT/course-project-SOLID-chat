package use_cases.emoji_manager;

import javax.swing.*;
import java.net.URL;

public class ChatEmo extends ImageIcon {
	/**
	 * the description of emoji
	 */
	private static final long serialVersionUID = 1L;
	int im;// the code of emo

	public ChatEmo(URL url, int im) {
		super(url);
		this.im = im;
	}

	public int getIm() {
		return im;
	}
}