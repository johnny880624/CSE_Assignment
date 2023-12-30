package assignment5;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

import javax.swing.JFileChooser;

import edu.princeton.cs.introcs.StdDraw;

/**
 * A Zombie Simulator!
 */
public class ZombieSimulator {
	public static final int X = 0;
	public static final int Y = 1;
	private static final String ZOMBIE_TOKEN_VALUE = "Zombie";

	private static final Color ZOMBIE_COLOR = new Color(146, 0, 0);
	private static final Color NONZOMBIE_COLOR = new Color(0, 0, 0);
	private static final Color TEXT_COLOR = new Color(73, 0, 146);
	public static final double ENTITY_RADIUS = 0.008;

	public static final double RANDOM_DELTA_HALF_RANGE = 0.006;

	

	/**
	 * Read entities from a file.
	 */
	public static void readEntities(Scanner in, boolean[] areZombies, double[][] positions) {

		// TODO: Implement this function 
		// (you can probably adjust code from Assignment 4)
		for (int i=0; i<areZombies.length; i++) {
			String temp_Str = in.next();
			if (temp_Str.equals("Zombie")) {
				areZombies[i] = true;
			}
			else {
				areZombies[i] = false;
			}
			for (int j=0; j<positions[i].length;j++) {
				positions[i][j] = in.nextDouble();
			}	
		}
	}

	/**
	 * Draw all the entities. Zombies are drawn as ZOMBIE_COLOR filled circles of
	 * radius ENTITY_RADIUS and non-zombies with filled NONZOMBIE_COLOR filled
	 * circles of radius ENTITY_RADIUS). Further, add feedback for nonzombie count
	 * (when ready to do so), and any additional desired drawing features.
	 * 
	 * @param areZombies the zombie state of each entity
	 * @param positions  the (x,y) position of each entity
	 */
	public static void drawEntities(boolean[] areZombies, double[][] positions) {
		// DONE: Clear the frame
		StdDraw.clear();

		// TODO: Write the loop that displays all the entities 
		// (you can probably adjust code from Assignment 4)
		for (int i =0; i<positions.length; i++) {
			if (areZombies[i] == true) {
				StdDraw.setPenColor(ZOMBIE_COLOR);
			}
			else {
				StdDraw.setPenColor(NONZOMBIE_COLOR);
			}
			for(int j =0; j<positions[i].length-1;j++) {
				StdDraw.filledCircle(positions[i][j], positions[i][j+1], ENTITY_RADIUS);
			}
		}
		// DONE: Show everything that was drawn (show the updated frame). This should be
		// the only "show()" command!
		StdDraw.show();
	}

	/**
	 * Check if the entity at the given index is touching a zombie. (HINT: You know
	 * the location of the center of each entity and that they all have a radius of
	 * ENTITY_RADIUS. If the circles representing two entities overlap they are
	 * considered to be touching. Consider using the distance formula.)
	 *
	 * @param index      the index of the entity to check
	 * @param areZombies the zombie state of each entity
	 * @param positions  the (x,y) position of each entity
	 * @return true if the entity at index is touching a zombie, false otherwise
	 */
	public static boolean touchingZombie(int index, boolean[] areZombies, double[][] positions) {
		// TODO: Complete this method
		double index_x = positions[index][0];
		double index_y = positions[index][1];
		for (int i =0; i<positions.length;i++) {
			if (Math.sqrt(Math.pow(positions[i][0]-index_x,2)+Math.pow(positions[i][1]-index_y,2))<=ENTITY_RADIUS*2) {
				if (areZombies[i] == true) {
					return true;
				}
			}
		}
		return false; // FIXME: Replace this so it returns the value of interest
	}

	/**
	 * Update the areZombies states and positions of all entities (assume Brownian
	 * motion).
	 *
	 * The rules for an update are:
	 * 
	 * Each entity should move by a random value between -RANDOM_DELTA_HALF_RANGE 
	 * and +RANDOM_DELTA_HALF_RANGE in both the x and the y coordinates.
	 * 
	 * Entities should not be able to leave the screen. x and y coordinates should
	 * be kept between [0-1.0]
	 *
	 * If a non-zombie is touching a zombie it should change to a zombie. (HINT: you
	 * need to check all entities. On each one that is NOT a zombie, you can re-use
	 * code you've already written to see if it's "touching" a Zombie and, if so,
	 * change it to a zombie.)
	 *
	 * @param areZombies the zombie state of each entity
	 * @param positions  the (x,y) position of each entity
	 */
	public static void updateEntities(boolean[] areZombies, double[][] positions) {
		// TODO: Complete this method: It should update the positions of items in the
		// entities array
		for (int i =0; i<positions.length;i++) {
 			double check_x = positions[i][0] -RANDOM_DELTA_HALF_RANGE  + (Math.random() * RANDOM_DELTA_HALF_RANGE * 2);
 			if ( 0<= check_x && check_x<=1) {
 				positions[i][0] =  check_x;
 			}
			double check_y = positions[i][1] -RANDOM_DELTA_HALF_RANGE  + (Math.random() * RANDOM_DELTA_HALF_RANGE * 2);
			if ( 0<= check_y && check_y<=1) {
				positions[i][1] = check_y;
			}
			areZombies[i] = touchingZombie(i,areZombies, positions);
			
		}	
	}

	/**
	 * Return the number of nonzombies remaining
	 */
	// TODO: Change TodoReplaceWithCorrectReturnType to appropriate return type.
	// TODO: Change TodoReplaceWithCorrectParameterType to appropriate parameter type.
	// TODO: Rename todoRenameMe.
	 public static int nonzombieCount(boolean[] areZombies) {
		 int count = 0;
		 for (int i=0;i<areZombies.length; i++) {
			 if(areZombies[i]== false) {
			 count ++;
			 }
		 }
		 return count; 
//	     TODO: complete this method
	 }

	/**
	 * Run the zombie simulation.
	 */
	private static void runSimulation(Scanner in) {
		StdDraw.enableDoubleBuffering(); // reduce unpleasant drawing artifacts, speed things up

		// TODO: Uncomment and fix the code below.
		 int N = in.nextInt();
		 boolean[] areZombies = new boolean[N];
		 double[][] positions = new double[N][2]; 
		 readEntities(in, areZombies, positions);
		 drawEntities(areZombies, positions);
		
		StdDraw.pause(500);

		// TODO: Write the loop that will run the simulation.
		// Continue if nonzombies remain
		// Update zombie state and positions
		// Redraw
		while (nonzombieCount(areZombies)>0) {
			StdDraw.clear();
			updateEntities(areZombies,positions);
			for (int i = 0;i<positions.length;i++) {
				if (areZombies[i] == true) {
					StdDraw.setPenColor(Color.RED);
				}
				else {
					StdDraw.setPenColor(Color.BLACK);
				}
				StdDraw.filledCircle(positions[i][0], positions[i][1], ENTITY_RADIUS);
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.text(0.2, 0.05, "Human Left: " + nonzombieCount(areZombies) + "/" + areZombies.length);
			}
			StdDraw.show();
		}
		
		
	}

	public static void main(String[] args) throws FileNotFoundException {
		JFileChooser chooser = new JFileChooser("zombieSim");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		
	}

}
