package practice6;

import assignment6.RecursiveMethods;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class Substitutions {
	public static void main(String[] args) {
		String text = "L_G";
		String textPrime = RecursiveMethods.substituteAll(text,'L' , "LEGOLAS");
		System.out.println(textPrime);
		String textPrimetext = RecursiveMethods.substituteAll(textPrime,'G' , "GIMLI");
		System.out.println(textPrimetext);
		
//		System.out.println("----------------");
//		String textPrime1 = RecursiveMethods.substituteAll(text,'L' , "LEeOLAS");
//		System.out.println(textPrime1);
//		String textPrimetext1 = RecursiveMethods.substituteAll(textPrime1,'G' , "GIMLI");
//		System.out.println(textPrimetext1);
//		String textPrimetext2 = RecursiveMethods.substituteAll(textPrimetext1,'e' , "G");
//		System.out.println(textPrimetext2);
		
	}
}
