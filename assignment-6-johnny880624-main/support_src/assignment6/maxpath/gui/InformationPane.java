package assignment6.maxpath.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Optional;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class InformationPane extends JPanel {
	private static final long serialVersionUID = 1L;

	private static class CustomCell extends AbstractCellComponent {
		private static final long serialVersionUID = 1L;

		private final boolean isSolution;

		private CustomCell(boolean isStart, boolean isStone, Optional<Integer> opt, boolean isOnPath,
				boolean isSolution) {
			super(0, 0);
			this.isSolution = isSolution;
			if (isStart) {
				updateCell0(0, 0);
			}
			updateOpt(opt);
			if (isOnPath) {
				updateOnMaxPath(opt.get());
			}
			setSelected(!isStone);
		}

		@Override
		public boolean isStone() {
			return !isSelected();
		}

		@Override
		protected void updateText(String text) {
			setText(text);
		}

		@Override
		protected void updateColor(Color color) {
			if (isSolution) {
				setBackground(color);
			}
		}
	}

	private static final Insets DEFAULT_INSETS = new Insets(2, 2, 2, 2);
	private static final Insets INSTRUCTOR_INSETS = new Insets(2, 48, 2, 2);

	public InformationPane() {
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		addStudentComponent(new JLabel("student"), gbc);
		addInstructorComponent(new JLabel("instructor"), gbc);
		addStudentComponent(new JSeparator(), gbc);
		addInstructorComponent(new JSeparator(), gbc);
		addStudentPair(true, true, Optional.of(131), "start stone", gbc);
		addInstructorPair(true, true, Optional.of(131), true, "start stone", gbc);
		addStudentPair(false, true, Optional.empty(), "stone", gbc);
		addInstructorPair(false, true, Optional.empty(), false, "stone unreached", gbc);
		addStudentSpacer(gbc);
		addInstructorPair(false, true, Optional.of(42), true, "stone on max path", gbc);
		addStudentSpacer(gbc);
		addInstructorPair(false, true, Optional.of(23), false, "stone on other path", gbc);
		addStudentPair(true, false, Optional.of(0), "start chasm", gbc);
		addInstructorPair(true, false, Optional.of(0), false, "start chasm", gbc);
		addStudentPair(false, false, Optional.empty(), "chasm", gbc);
		addInstructorPair(false, false, Optional.empty(), false, "chasm unreached", gbc);
		addStudentSpacer(gbc);
		addInstructorPair(false, false, Optional.of(0), false, "chasm reached", gbc);
	}

	private void addPair(boolean isStart, boolean isStone, Optional<Integer> opt, boolean isOnPath, boolean isSolution,
			String text, GridBagConstraints gbc) {
		gbc.gridwidth = 1;
		add(new CustomCell(isStart, isStone, opt, isOnPath, isSolution), gbc);
		if (isSolution) {
			gbc.gridwidth = GridBagConstraints.REMAINDER;
			gbc.insets = DEFAULT_INSETS;
		}
		add(new JLabel(text), gbc);
	}

	private void addStudentPair(boolean isStart, boolean isStone, Optional<Integer> opt,
			String text, GridBagConstraints gbc) {
		gbc.insets = DEFAULT_INSETS;
		addPair(isStart, isStone, opt, false, false, text, gbc);
	}

	private void addStudentComponent(JComponent component, GridBagConstraints gbc) {
		gbc.gridwidth = 2;
		gbc.insets = DEFAULT_INSETS;
		add(component, gbc);
	}

	private void addStudentSpacer(GridBagConstraints gbc) {
		addStudentComponent(new JLabel(), gbc);
	}

	private void addInstructorPair(boolean isStart, boolean isStone, Optional<Integer> opt,
			boolean isOnPath, String text, GridBagConstraints gbc) {
		gbc.insets = INSTRUCTOR_INSETS;
		addPair(isStart, isStone, opt, isOnPath, true, text, gbc);
	}

	private void addInstructorComponent(JComponent component, GridBagConstraints gbc) {
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = INSTRUCTOR_INSETS;
		add(component, gbc);
	}

	@Override
	public boolean contains(int x, int y) {
		return false;
	}
}
