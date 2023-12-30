package support.cse131.gui;

import java.awt.Font;
import java.awt.event.ItemListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class MultipleSelectPane<K> extends JPanel {
	private static final long serialVersionUID = 1L;
	private final Map<K, CheckBoxAndOnlyButtonPane<K>> map = new HashMap<>();

	public MultipleSelectPane(String title, List<K> items, ItemListener itemListener) {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 8));
		HyperlinkButton allButton = new HyperlinkButton("all");
		allButton.addActionListener((e) -> {
			all();
		});

		JLabel titleLable = new JLabel(title);
		titleLable.setFont(titleLable.getFont().deriveFont(16.0f).deriveFont(Font.BOLD));
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.LINE_AXIS));
		header.add(titleLable);
		header.add(allButton);
		header.setAlignmentX(LEFT_ALIGNMENT);
		add(header);
		for (K item : items) {
			CheckBoxAndOnlyButtonPane<K> control = new CheckBoxAndOnlyButtonPane<>(item, itemListener, (k) -> only(k));
			map.put(item, control);
			add(control);
		}
	}

	public Map<K, Boolean> getSelectedMap() {
		return map.entrySet().stream()
				.collect(Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().getCheckBox().isSelected()));
	}

	private void all() {
		for (CheckBoxAndOnlyButtonPane<K> control : map.values()) {
			control.getCheckBox().setSelected(true);
		}
	}

	private void only(K item) {
		for (CheckBoxAndOnlyButtonPane<K> control : map.values()) {
			control.getCheckBox().setSelected(Objects.equals(control.getKey(), item));
		}
	}
}
