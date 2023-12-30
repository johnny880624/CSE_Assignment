package assignment8.debug;

import java.util.Arrays;
import java.util.List;

/** 
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DrawEntities {
	private static DrawEntitiesCase aZombieCase() {
		boolean[] areZombies = { true };
		double[][] positions = { { 0.75, 0.5 } };
		String message = String.format(
				"<html>Does the screen show a zombie at (%.2f, %.2f)?<br/>Note: we have added crosshairs at this location.</html>",
				positions[0][0], positions[0][1]);
		return new DrawEntitiesCase(areZombies, positions, message);
	}

	private static DrawEntitiesCase aNonzombieCase() {
		boolean[] areZombies = { false };
		double[][] positions = { { 0.33, 0.67 } };
		String message = String.format(
				"<html>Does the screen show a non-zombie at (%.2f, %.2f)?<br/>Note: we have added crosshairs at this location.</html>",
				positions[0][0], positions[0][1]);
		return new DrawEntitiesCase(areZombies, positions, message);
	}

	private static DrawEntitiesCase twoEntitiesCase() {
		boolean[] areZombies = { false, true };
		double[][] positions = { { 0.1, 0.2 }, { 0.4, 0.8 } };
		String message = String.format(
				"<html>Does the screen show both a nonzombie at (%.2f, %.2f) and a zombie at (%.2f, %.2f)?<br/>Note: we have added crosshairs at these locations.</html>",
				positions[0][0], positions[0][1], positions[1][0], positions[1][1]);
		return new DrawEntitiesCase(areZombies, positions, message);
	}

	public static List<DrawEntitiesCase> getCases() {
		return Arrays.asList(aZombieCase(), aNonzombieCase(), twoEntitiesCase());
	}
}
