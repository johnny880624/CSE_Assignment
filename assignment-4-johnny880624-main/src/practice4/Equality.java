package practice4;

import java.util.Scanner;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class Equality {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("a?");
		String a = in.nextLine();
		System.out.println("b?");
		String b = in.nextLine();

		System.out.println("a: \"" + a + "\"");
		System.out.println("b: \"" + b + "\"");
		System.out.println();

		System.out.println("***NOT*** RECOMMENDED.  Do ***NOT*** use == for Strings.");
		System.out.println("=========------------------=========--------------------");
		System.out.println("a==b?");
		System.out.println(a == b);
		System.out.println();

		System.out.println("Recommended.  Use a.equals(b) for Strings.");
		System.out.println("------------------------------------------");
		System.out.println("a.equals(b)?");
		System.out.println(a.equals(b));
		System.out.println();
	}
}
