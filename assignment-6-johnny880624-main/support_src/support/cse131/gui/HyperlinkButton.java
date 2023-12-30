package support.cse131.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.TextAttribute;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class HyperlinkButton extends JButton {
	private static final long serialVersionUID = 1L;

	public HyperlinkButton(String text) {
		super(text);
		setOpaque(false);
		setBorderPainted(false);
		setBorder(BorderFactory.createEmptyBorder());
		setContentAreaFilled(false);
		setForeground(Color.BLUE.darker());
		Font font = getFont();
		@SuppressWarnings("unchecked")
		Map<TextAttribute, Object> attributes = (Map<TextAttribute, Object>)font.getAttributes();
		attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
		Font underlineFont = font.deriveFont(attributes);
		setFont(underlineFont);
	}
}
