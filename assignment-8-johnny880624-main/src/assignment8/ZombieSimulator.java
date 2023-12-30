package assignment8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JFileChooser;

import edu.princeton.cs.introcs.StdDraw;
import support.cse131.NotYetImplementedException;
import support.cse131.Timing;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class ZombieSimulator {
	private static final String ZOMBIE_TOKEN_VALUE = "Zombie";
	private Entity[] entities;


	/**
	 * Constructs a ZombieSimulator with an empty array of Entities.
	 */
	public ZombieSimulator(int n) {
		// FIXME
		this.entities = new Entity[n];
	}

	/**
	 * @return the current array of entities 
	 */
	public Entity[] getEntities() {
		// FIXME
		return this.entities;
	}

	/** 
	 * Reads an entire zombie simulation file from a specified ArgsProcessor, adding
	 * each Entity to the array of entities.
	 *
	 * Assume that N (the integer indicating how many entities are in the simulation) has already been read in
	 * and passed into the constructor.
	 *
	 * @param in Scanner to read the complete zombie simulation file format.
	 */
	public void readEntities(Scanner in) {
		// FIXME
		boolean isZombie;
		double x;
		double y;
		for (int i = 0; i < this.entities.length; i++) {
			String tempStr = in.next();
			if (tempStr.equals("Zombie")) {
				isZombie = true;
			}
			else {
				isZombie = false;
			}
			x = in.nextDouble();
			y = in.nextDouble();
			if (isZombie == true) {
				entities[i] = new Zombie(x,y);
			} else {
				entities[i] = new Nonzombie(x,y);
			}
		}
	}

	/**
	 * @return the number of zombies in entities.
	 */
	public int getZombieCount() {
		// FIXME
		int countZombie = 0;
		for (int i = 0; i < this.entities.length; i++) {
			if (entities[i].isZombie()) {
				countZombie ++;
			}
		}
		return countZombie;
	}

	/**
	 * @return the number of nonzombies in entities.
	 */
	public int getNonzombieCount() {
		// FIXME
		int countNonzombie = 0;
		for (int i = 0; i < this.entities.length; i++) {
			if (entities[i].isZombie() == false) {
				countNonzombie ++;
			}
		}
		return countNonzombie;
	}

	/**
	 * Draws a frame of the simulation.
	 */
	public void draw() {
		StdDraw.clear();

		// NOTE: feel free to edit this code to support additional features
		for (Entity entity : getEntities()) {
			entity.draw();
		}

		StdDraw.show(); // commit deferred drawing as a result of enabling double buffering
	}

	/**
	 * Updates the entities for the current frame of the simulation given the amount
	 * of time passed since the previous frame.
	 * 
	 * Note: some entities may be consumed and will not remain for future frames of
	 * the simulation.
	 * 
	 * @param deltaTime the amount of time since the previous frame of the
	 *                  simulation.
	 */
	public void update() {
		// FIXME
		for (int i = 0; i < this.entities.length; i++) {
			this.entities[i] = this.entities[i].update(this.entities);
		}
	}
	
	/**
	 * Runs the zombie simulation.
	 * 
	 * @param args arguments from the command line
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		StdDraw.enableDoubleBuffering(); // reduce unpleasant drawing artifacts, speed things up

		JFileChooser chooser = new JFileChooser("zombieSims");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File

		ZombieSimulator zombieSimulator = new ZombieSimulator(in.nextInt());
		zombieSimulator.readEntities(in);

		double prevTime = Timing.getCurrentTimeInSeconds();
		while (zombieSimulator.getNonzombieCount() >= 0) {

			zombieSimulator.update();
			zombieSimulator.draw();

			StdDraw.pause(20);

		}
	}
}
