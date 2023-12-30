package assignment3;
import java.util.Scanner;


public class BubbleSort {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Enter the number of elements: ");
        int n = in.nextInt();
        
        
        int[] number = new int[n];
		System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            number[i] = in.nextInt();
        }
        System.out.print("Given values:");
		for (int i=0; i <number.length; i++) {
			System.out.print(number[i]);
		}
		System.out.println("\n");
//		int [] number = {8,6,7,5,3,0,9};
		for (int i=0; i < number.length-1; i++) {
			for (int j=0; j < number.length-1-i; j ++) {
				int temp_number1 = number[j];
				int temp_number2 = number[j+1];
				if (number[j]>number[j+1]) {
					number[j] = temp_number2;
					number[j+1] = temp_number1;
				}
			}
		}
		System.out.print("Sorted values:");
		for (int i=0; i <number.length; i++) {
			System.out.print(number[i]);
		}
		System.out.println("\n");
        
        
	}

}
