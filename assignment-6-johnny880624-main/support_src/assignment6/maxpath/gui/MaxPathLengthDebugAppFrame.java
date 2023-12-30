package assignment6.maxpath.gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import assignment6.maxpath.MaxPathLengthScenarios;
import support.cse131.gui.LookAndFeels;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class MaxPathLengthDebugAppFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private final JCheckBox displayCorrectResultsCheckBox;

	private final JPanel mainPane;
	private final List<ScenarioPane> scenarioPanes;

	public MaxPathLengthDebugAppFrame() {
		super("Max Path Length Debug App");
		mainPane = new JPanel();
		mainPane.setLayout(new BoxLayout(mainPane, BoxLayout.PAGE_AXIS));
		mainPane.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		String[] scenarios = MaxPathLengthScenarios.scenariosAsArray();

		List<Callable<Integer>> tasks = new ArrayList<>(scenarios.length);
		for (int i = 0; i < scenarios.length; ++i) {
			String scenario = scenarios[i];
			tasks.add(() -> {
				return MaxPathLengthScenarios.calculateActual(scenario);
			});
		}
		ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		List<Future<Integer>> futures;
		try {
			futures = executorService.invokeAll(tasks);
		} catch (InterruptedException ie) {
			throw new RuntimeException(ie);
		}

		scenarioPanes = new ArrayList<>(scenarios.length);
		int correctCount = 0;
		int i = 0;
		for (Future<Integer> future : futures) {
			ScenarioPane scenarioPane = new ScenarioPane(scenarios[i], future);
			if (scenarioPane.isCorrect()) {
				++correctCount;
			}
			scenarioPanes.add(scenarioPane);
			++i;
		}

		JScrollPane scrollPane = new JScrollPane(mainPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setUnitIncrement(24);

		displayCorrectResultsCheckBox = new JCheckBox("include correct results?");
		displayCorrectResultsCheckBox.addItemListener((e) -> updateResultsViews());
		displayCorrectResultsCheckBox.setSelected(true);

		JLabel correctCountLabel = new JLabel(String.format("%d/%d correct", correctCount, scenarios.length));
		if (correctCount != scenarios.length) {
			correctCountLabel.setIcon(LookAndFeels.getErrorIcon());
		}

		JPanel leftHeader = new JPanel();
		leftHeader.setLayout(new BoxLayout(leftHeader, BoxLayout.LINE_AXIS));
		leftHeader.add(correctCountLabel);
		leftHeader.add(Box.createHorizontalStrut(24));
		leftHeader.add(displayCorrectResultsCheckBox);

		JButton infoButton = new JButton(LookAndFeels.getInformationIcon());
		infoButton.addActionListener((e) -> {
			JOptionPane.showMessageDialog(this, new InformationPane(), "Chart Key", JOptionPane.PLAIN_MESSAGE);
		});

		JPanel header = new JPanel();
		header.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
		header.setLayout(new BorderLayout());
		header.add(leftHeader, BorderLayout.LINE_START);
		header.add(infoButton, BorderLayout.LINE_END);

		getContentPane().add(header, BorderLayout.PAGE_START);
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		SwingUtilities.invokeLater(() -> mainPane.requestFocusInWindow());
	}

	private void updateResultsViews() {
		mainPane.removeAll();
		for (ScenarioPane scenarioPane : scenarioPanes) {
			if (displayCorrectResultsCheckBox.isSelected() || !scenarioPane.isCorrect()) {
				mainPane.add(scenarioPane);
				mainPane.add(Box.createVerticalStrut(24));
			}
		}
		mainPane.revalidate();
	}

	public static void createAndShowGUI() {
		try {
			if (LookAndFeels.setNimbusLookAndFeel()) {
				UIManager.getLookAndFeelDefaults().put("defaultFont", new Font(Font.SANS_SERIF, 0, 18));
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// it is almost never the correct solution to only printing a stack trace.
			// i believe it is correct here.
			// -- dennis
			e.printStackTrace();
		}

		JFrame frame = new MaxPathLengthDebugAppFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}

}
