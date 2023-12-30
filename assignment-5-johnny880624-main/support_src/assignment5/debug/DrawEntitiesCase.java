package assignment5.debug;

import javax.swing.Icon;

import assignment5.ZombieSimulator;
import support.cse131.DrawCase;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DrawEntitiesCase implements DrawCase {
	private final boolean[] areZombies;
	private final double[][] positions;
	private final String text;

	public DrawEntitiesCase(boolean[] areZombies, double[][] positions, String text) {
		this.areZombies = areZombies;
		this.positions = positions;
		this.text = text;
	}

	public boolean[] areZombies() {
		return areZombies;
	}

	public double[][] positions() {
		return positions;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void draw() {
		ZombieSimulator.drawEntities(areZombies, positions);
	}

	@Override
	public Icon getIcon() {
		return null;
	}
}
