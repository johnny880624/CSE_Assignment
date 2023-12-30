package assignment6.maxpath.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import assignment6.maxpath.Cell;
import assignment6.maxpath.MaxPathLengthScenarios;
import support.cse131.gui.ThrowableDialogs;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class ScenarioPane extends JPanel {
	private static final long serialVersionUID = 1L;

	private boolean isCorrect;

	private static abstract class AbstractPane extends JPanel {
		private static final long serialVersionUID = 1L;

		AbstractPane(String headerText, JPanel pane) {
			JLabel label = new JLabel(headerText);
			this.setLayout(new BorderLayout());
			add(label, BorderLayout.PAGE_START);
			add(pane, BorderLayout.LINE_START);
		}
	}

	private static class StudentPane extends AbstractPane {
		private static final long serialVersionUID = 1L;

		private static String toText(Optional<Integer> actualOpt) {
			return actualOpt.isPresent() ? Integer.toString(actualOpt.get()) : "?";
		}

		public StudentPane(boolean[][] stones, int row0, int column0, Optional<Integer> actualOpt) {
			super(String.format("<html>Student<br/>RecursiveMethods.maxPathLength(): %s</html>", toText(actualOpt)),
					new StudentChartPane(stones, row0, column0, toText(actualOpt)));
		}
	}

	private static class InstructorPane extends AbstractPane {
		private static final long serialVersionUID = 1L;

		public InstructorPane(boolean[][] stones, int row0, int column0, Optional<Integer>[][] opts,
				List<Cell> maxPath) {
			super(String.format("<html>Instructor<br/>expected: %d</html>", opts[row0][column0].get()),
					new InstructorChartPane(stones, row0, column0, opts, maxPath));
		}

	}

	public ScenarioPane(String scenario, Future<Integer> actualFuture) {
		setLayout(new BorderLayout());

		boolean[][] stones = MaxPathLengthScenarios.parseStones(scenario);
		int row0 = MaxPathLengthScenarios.parseRow0(scenario);
		int column0 = MaxPathLengthScenarios.parseColumn0(scenario);
		Optional<Integer>[][] opts = MaxPathLengthScenarios.lookupOpts(scenario);
		List<Cell> maxPath = MaxPathLengthScenarios.lookupMaxPath(scenario);

		int expected = MaxPathLengthScenarios.lookupExpected(scenario);

		JPanel header = new JPanel();
		header.setLayout(new BorderLayout());

		JLabel descriptionLabel = new JLabel();
		descriptionLabel.setFont(descriptionLabel.getFont().deriveFont(Font.BOLD, 24.0f));

		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append(MaxPathLengthScenarios.lookupDescription(scenario));
		sb.append("<br/>");

		Optional<Integer> actualOpt;
		try {
			int actual = actualFuture.get();
			actualOpt = Optional.of(actual);
			isCorrect = expected == actual;
			if (isCorrect) {
				sb.append("correct");
			} else {
				sb.append("INCORRECT.  expected: ").append(expected).append("; actual: ").append(actual);
			}
			header.add(descriptionLabel, BorderLayout.LINE_START);
		} catch (InterruptedException ie) {
			throw new RuntimeException(ie);
		} catch (ExecutionException e) {
			isCorrect = false;
			actualOpt = Optional.empty();
			Throwable t = e.getCause();
			sb.append("INCORRECT. expected: ").append(expected).append("; actual: ")
					.append(t.getClass().getSimpleName());
			AbstractButton button = ThrowableDialogs.newButton(header, t);
			button.setHorizontalAlignment(SwingConstants.LEFT);

			JPanel pane = new JPanel();
			pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));

			descriptionLabel.setVerticalAlignment(SwingConstants.BOTTOM);
			button.setVerticalAlignment(SwingConstants.BOTTOM);
			pane.add(descriptionLabel);
			pane.add(Box.createHorizontalStrut(12));
			pane.add(button);

			header.add(pane, BorderLayout.LINE_START);
			e.printStackTrace();
		}
		sb.append("</html>");

		descriptionLabel.setText(sb.toString());
		if (!isCorrect) {
			descriptionLabel.setIcon(UIManager.getIcon("OptionPane.errorIcon"));
		}

		add(header, BorderLayout.PAGE_START);

		JPanel chartsPane = new JPanel();
		chartsPane.setLayout(new BoxLayout(chartsPane, BoxLayout.LINE_AXIS));

		chartsPane.add(Box.createHorizontalStrut(24));
		chartsPane.add(new StudentPane(stones, row0, column0, actualOpt));
		chartsPane.add(Box.createHorizontalStrut(32));
		chartsPane.add(new InstructorPane(stones, row0, column0, opts, maxPath));

		add(header, BorderLayout.PAGE_START);
		add(chartsPane, BorderLayout.LINE_START);
	}

	public boolean isCorrect() {
		return isCorrect;
	}
}
