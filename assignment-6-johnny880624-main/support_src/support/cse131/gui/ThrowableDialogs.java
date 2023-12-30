package support.cse131.gui;

import java.awt.Dimension;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ThrowableDialogs {
	public static void prompt(JComponent parentComponent, Throwable t) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		t.printStackTrace(pw);
		JTextArea textArea = new JTextArea(sw.toString());
		JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(600, 400));
		scrollPane.setMaximumSize(new Dimension(100, 100));
		JOptionPane.showMessageDialog(parentComponent, scrollPane);
	}

	public static HyperlinkButton newHyperlinkButton(JComponent parentComponent, Throwable t) {
		String message = t.getLocalizedMessage();
		if (message.length() > 48) {
			message = message.subSequence(0, 40) + "...";
		}
		HyperlinkButton button = new HyperlinkButton(
				"<html>" + t.getClass().getSimpleName() + "<br/>" + message + "</html>");
		button.addActionListener((e) -> prompt(parentComponent, t));
		return button;
	}

	public static JButton newButton(JComponent parentComponent, Throwable t) {
		JButton button = new JButton("Show Stacktrace...");
		button.addActionListener((e) -> prompt(parentComponent, t));
		return button;
	}
}
