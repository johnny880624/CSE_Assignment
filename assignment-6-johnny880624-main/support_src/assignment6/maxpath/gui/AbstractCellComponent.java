
package assignment6.maxpath.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Optional;

import javax.swing.JToggleButton;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
abstract class AbstractCellComponent extends JToggleButton {
	private static final long serialVersionUID = 1L;
	private static final Color CONNECTED_COLOR = new Color(240, 228, 66);
	private static final Color ON_MAX_PATH_COLOR = new Color(0, 158, 115);
	private final Color DEFAULT_COLOR;

	private final int row;
	private final int column;
	private boolean isCell0;

	public AbstractCellComponent(int row, int column) {
		this.row = row;
		this.column = column;
		DEFAULT_COLOR = getBackground();
	}

	public abstract boolean isStone();

	public void updateCell0(int row, int column) {
		boolean prev = isCell0;
		boolean next = this.row == row && this.column == column;
		if (prev != next) {
			isCell0 = next;
			repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (isCell0) {
			int w = getWidth();
			int h = getHeight();
			int r = h / 8;

			paintYouAreHere((Graphics2D) g, w / 8 + 4, r + 4, h / 8);
		}
	}

	private void paintYouAreHere(Graphics2D g2, int x, int y, int r) {
		Object prevAntialias = g2.getRenderingHint(RenderingHints.KEY_ANTIALIASING);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(new Color(0, 0, 0));
		g2.fillOval(x - r, y - r, r + r, r + r);

		// TODO: join with PI/4 spots
		int[] xs = { x - r, x + r, x };
		int[] ys = { y, y, y + r + r };
		g2.fillPolygon(xs, ys, xs.length);

		int innerRadius = (r * 6) / 10;
		g2.setColor(Color.WHITE);
		g2.fillOval(x - innerRadius, y - innerRadius, innerRadius + innerRadius,
				innerRadius + innerRadius);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, prevAntialias);
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension size = super.getPreferredSize();
		size.width = Math.max(size.width, 64);
		size.height = size.width;
		return size;
	}
	
	protected abstract void updateText(String text);

	protected abstract void updateColor(Color color);

	public void updateOpt(Optional<Integer> opt) {
		String text;
		updateColor(DEFAULT_COLOR);
		if (opt.isPresent()) {
			text = Integer.toString(opt.get());
			if (opt.get() > 0) {
				updateColor(CONNECTED_COLOR);
			}
		} else {
			text = "";
		}
		updateText(text);
	}

	public void updateOnMaxPath(int n) {
		updateColor(ON_MAX_PATH_COLOR);
		updateText(Integer.toString(n));
	}
}
