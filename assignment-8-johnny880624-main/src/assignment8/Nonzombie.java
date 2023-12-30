package assignment8;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.NotYetImplementedException;

public class Nonzombie extends Entity {

	public static final double NONZOMBIE_SPEED = 0.01;

	/**
	 * 
	 * @param x coordinate
	 * @param y coordinate
	 */
	public Nonzombie(double x, double y) {
		// FIXME
		super(x, y, false, NONZOMBIE_SPEED);
	}
	
	/**
	 * Create a Zombie object in place of the current Nonzombie 
	 * @return the new Zombie object
	 */
	public Zombie convert() {
		// FIXME
		return new Zombie(super.getX(),super.getY());
	}
	
	/**
	 * Draw a Nonzombie
	 */
	public void draw() {
		// FIXME
		if (this.isAlive()) {
			StdDraw.setPenColor(Color.black);
			StdDraw.filledCircle(this.getX(), this.getY(), this.getRadius());
		}
	}

	/**
	 * Update the Nonzombie
	 * @param entities the array of Entity objects in the simulation, consumed or not
	 * @param deltaTime the time since the last frame
	 * @return the new Entity object to take the place of the current one
	 */
	public Entity update(Entity[] entities) {
		// FIXME
		if (entities.length == 1) {
			return this;
		}
		Zombie closestZombie = this.findClosestZombie(entities);
		// 1. Stay away from Zombie
		if (Math.random() <0.333) {
			if (closestZombie != null) {
				this.moveAwayFrom(closestZombie);
				this.checkBounds();
			}
			if (this.isTouching(closestZombie) && closestZombie != null) {
				if (Math.random() < 0.8) {
		            // 80% chance to turn into a Zombie
		            return this.convert();
		        } else {
		            // 20% chance to be consumed
		            this.wasConsumed(); // Indicating this Nonzombie is consumed
		            closestZombie.consumeNonzombie();
		        }
			}
			return this;
		// 2. advance forward the nonZombie
		} else if (Math.random() <0.666 ) {
			Nonzombie closestNonZombie = this.findClosestNonzombie(entities);
			if (closestNonZombie != null) {
				this.moveToward(closestNonZombie);
				this.checkBounds();
			}
			if (this.isTouching(closestZombie) && closestZombie != null) {
				if (Math.random() < 0.8) {
		            // 80% chance to turn into a Zombie
		            return this.convert();
		        } else {
		            // 20% chance to be consumed
		            this.wasConsumed(); // Indicating this Nonzombie is consumed
		            closestZombie.consumeNonzombie();
		        }
			}
			return this;
		// 3. Get away from any entity
		} else {
			Entity entity = this.findClosestEntity(entities);
			if (entity != null) {
				this.moveAwayFrom(entity);
				this.checkBounds();
			}
			if (this.isTouching(closestZombie) && closestZombie != null) {
				if (Math.random() < 0.8) {
		            // 80% chance to turn into a Zombie
		            return this.convert();
		        } else {
		            // 20% chance to be consumed
		            this.wasConsumed(); // Indicating this Nonzombie is consumed
		            closestZombie.consumeNonzombie();
		        }
			}
			return this;
		}	
	}

}