package assignment6.maxpath.gui;

import java.awt.Dimension;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class StudentChartPane extends ChartPane {
	private static final long serialVersionUID = 1L;

	public StudentChartPane(boolean[][] stones, int row0, int column0, String text) {
		super(stones, row0, column0);
		chart[row0][column0].setText(text);
	}

	@Override
	public Dimension getMaximumSize() {
		return getPreferredSize();
	}
}
