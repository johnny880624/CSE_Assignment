package assignment8;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.NotYetImplementedException;

public class Zombie extends Entity {

	public static final double ZOMBIE_SPEED = 0.011;

	/**
	 * Create a new Zombie object
	 * @param x coordinate
	 * @param y coordinate
	 */
	public Zombie(double x, double y){
		// FIXME
		super(x, y, true, ZOMBIE_SPEED);
	}

	/**
	 * Grow the Zombie after consuming a Nonzombie
	 */
	public void consumeNonzombie(){
		// FIXME
		if (this.getRadius() <= 0.02) {
			this.setRadius(this.getRadius()* 1.2);
		}
	}

	/**
	 * Draw the Zombie
	 */
	public void draw() {
		// FIXME
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledCircle(this.getX(), this.getY(), this.getRadius());
	}


	/**
	 * Update the Zombie
	 * @param entities the array of Entity objects in the simulation, consumed or not
	 * @param deltaTime the time since the last frame
	 * @return the new Entity object to take the place of the current one
	 */
	public Entity update(Entity[] entities) {
		// FIXME
		Entity closestNonzombie = this.findClosestNonzombie(entities);
		if (closestNonzombie != null) {
			this.moveToward(closestNonzombie);
			this.checkBounds();
		}
		return this;
	}
}