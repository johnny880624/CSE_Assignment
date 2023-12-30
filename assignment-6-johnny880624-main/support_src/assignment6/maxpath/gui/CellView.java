
package assignment6.maxpath.gui;

import java.awt.Color;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class CellView extends AbstractCellComponent {
	private static final long serialVersionUID = 1L;

	public CellView(int row, int column, boolean isStone) {
		super(row, column);
		setSelected(!isStone);
	}

	@Override
	public boolean contains(int x, int y) {
		return false;
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
		setBackground(color);
	}
}
