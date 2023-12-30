package assignment6.maxpath.gui;

import java.awt.Dimension;
import java.util.List;
import java.util.Optional;

import assignment6.maxpath.Cell;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class InstructorChartPane extends ChartPane {
	private static final long serialVersionUID = 1L;

	public InstructorChartPane(boolean[][] stones, int row0, int column0, Optional<Integer>[][] opts,
			List<Cell> maxPath) {
		super(stones, row0, column0);

		for (int r = 0; r < chart.length; ++r) {
			for (int c = 0; c < chart[r].length; ++c) {
				chart[r][c].updateOpt(opts[r][c]);
			}
		}
		int n = maxPath.size();
		for (Cell cell : maxPath) {
			chart[cell.row()][cell.column()].updateOnMaxPath(n);
			n--;
		}
	}

	@Override
	public Dimension getMaximumSize() {
		return getPreferredSize();
	}
}
