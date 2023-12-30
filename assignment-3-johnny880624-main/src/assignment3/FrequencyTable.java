package assignment3;
import java.util.Arrays;
import java.util.Scanner;

public class FrequencyTable {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input how many number of intergers you want to generate: ");
		int n = in.nextInt();
		System.out.println("Maximun of integer: ");
		int max = in.nextInt();
		int [] number = new int[n];
		for (int i=0; i < n; i++) {
			// Math.random()*(upper -lower +1) + lower
			int random = (int)(Math.random()*(max-1+1))+1;
			number[i]= random;
		}
		Arrays.sort(number);

		int [] value = new int[n];
		int [] count = new int[n];
		int begin_number = number[0];
		int next_number = number[1];
		int counter = 0;
		int count1 = 0;
		int count2 = 0;
		for (int i =0; i <number.length; i++) {
//			Store every different value
			boolean isInList = false;
			for(int element: value) {
				if (element == number[i]) {
					isInList = true;
				}
			}
			if (isInList == false) {
				value[count1] = number[i];
				count1 ++;
			}
			
//			Calculate the number of each value
			if (next_number == begin_number) {
				counter ++;

				begin_number = next_number;
				if (i<number.length-2) {
					next_number = number[i+2];
				}
			}
			else {
				counter ++;
				count[count2] = counter;
				count2 ++;
				counter = 0;
				begin_number = next_number;
				if (i<number.length-2) {
					next_number = number[i+2];
				}
			}
		}
		count[count2] = counter;
		
		System.out.println("Frequencies for " + n + " randomly generated values between 1 and " + max);
		for (int i=0; i <value.length; i++) {
			if (value[i]!=0) {
				System.out.println(value[i]+ ": " + count[i]);
			}
		}
	}
}
