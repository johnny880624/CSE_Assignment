package assignment4;

import java.awt.Color;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;

import edu.princeton.cs.introcs.StdDraw;

public class ZombieData {

	public static void main(String[] args) throws Exception {
		// NOTE: The lines below will prompt the user with a file open dialog box.
		//       The contents of the selected file will be made available via the ArgsProcessor ap.
		JFileChooser chooser = new JFileChooser("zombieSims");
		chooser.showOpenDialog(null);
		File f = new File(chooser.getSelectedFile().getPath());
		Scanner in = new Scanner(f); //making Scanner with a File
		
		// TODO: 1. Read in the number of entities from Scanner

		// TODO: 2. Create the arrays that will hold entity data

		// TODO: 3. Read in all the Entity data

		// TODO: 4. Iterate through all the data and display it using StdDraw

	}
}
