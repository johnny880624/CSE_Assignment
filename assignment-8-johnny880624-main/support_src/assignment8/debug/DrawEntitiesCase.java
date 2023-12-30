package assignment8.debug;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import assignment8.Entity;
import assignment8.Nonzombie;
import assignment8.Zombie;
import assignment8.ZombieSimulator;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class DrawEntitiesCase {
	private final boolean[] areZombies;
	private final double[][] positions;
	private final String text;

	public DrawEntitiesCase(boolean[] areZombies, double[][] positions, String text) {
		this.areZombies = areZombies;
		this.positions = positions;
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public Entity[] getEntities() {
		Entity[] entities = new Entity[areZombies.length];
		for (int i = 0; i < areZombies.length; ++i) {
			entities[i] = areZombies[i] ? new Zombie(positions[i][0], positions[i][1]) : new Nonzombie(positions[i][0], positions[i][1]);
		}
		return entities;
	} 

	public ZombieSimulator createZombieSimulator() {
		String args = "";
		args += areZombies.length + " " ;
		for (int i = 0; i < areZombies.length; i++) {
			args += areZombies[i] ? "Zombie" : "Nonzombie";
			args += " ";
			args += positions[i][0] + " ";
			args += positions[i][1] + " ";
		} 

	    Scanner in = new Scanner(args);
		
		ZombieSimulator zombieSimulator = new ZombieSimulator(in.nextInt());
		zombieSimulator.readEntities(in);
		return zombieSimulator;
	}
}
