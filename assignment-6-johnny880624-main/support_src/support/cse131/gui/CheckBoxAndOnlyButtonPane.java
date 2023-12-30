package support.cse131.gui;

import java.awt.Component;
import java.awt.event.ItemListener;
import java.util.function.Consumer;

import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class CheckBoxAndOnlyButtonPane<K> extends JPanel {
	private static final long serialVersionUID = 1L;

	private final K key;
	private final JCheckBox checkBox;

	public CheckBoxAndOnlyButtonPane(K key, ItemListener checkBoxItemListener, Consumer<K> onlyButtonListener) {
		this.key = key;
		checkBox = new JCheckBox(key.toString(), true);
		setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		add(checkBox);
		checkBox.addItemListener(checkBoxItemListener);
		HyperlinkButton onlyButton = new HyperlinkButton("only");
		onlyButton.addActionListener((e) -> {
			onlyButtonListener.accept(key);
		});
		add(onlyButton);
		setAlignmentX(Component.LEFT_ALIGNMENT);
	}

	public K getKey() {
		return key;
	}

	public JCheckBox getCheckBox() {
		return checkBox;
	}

}
