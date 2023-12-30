package assignment3;
import java.util.Scanner;

public class SymmetricalImage {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("How many column? ");
		int col = in.nextInt(); 
		int half_col = col/2;
		System.out.println("How many rows? ");
		int row = in.nextInt(); 
		int half_row = row/2;
//		int []row_array1 = new int[row*col/4];
//		int []col_array1 = new int[row*col/4];
		int []row_array = new int[row*col/2];
		int []col_array = new int[row*col/2];
		// Math.random()*(upper -lower +1) + lower
		for (int i=0; i< row_array.length; i=i+2) {
			 int temp_row = (int)(Math.random()*(row-1+1)+1);
			 row_array[i] = temp_row;
			 row_array[i+1] = temp_row;
		}
		for (int i=0; i< col_array.length; i=i+2) {
			int temp_col = (int)(Math.random()*(col-1+1)+1);
			col_array[i] = temp_col;
			if (temp_col > half_col) {
				col_array[i+1] =  half_col - (temp_col-half_col)+1;
			}
			else {
				col_array[i+1] = half_col + (half_col-temp_col)+1;
			}
		}
		
//		int temp_col = 3;
//		int row_length = 10;
//		int new_column;
//		if (temp_col > half_row) {
//			new_column =  half_row - (temp_col-half_row)+1;
//		}
//		else {
//			new_column = half_row + (half_row-temp_col)+1;
//		}
//		System.out.println(new_column);
		
		for (int i=0; i< row_array.length; i++) {
			System.out.print(col_array[i]);
		}
		System.out.println("\n");
		System.out.println(col_array.length);
		
		for (int i=0; i< row_array.length; i++) {
			System.out.print(row_array[i]);
		}
		System.out.println("\n");
		System.out.println(row_array.length);

		
		String[][] matrix = new String[row][col];
		for (int i=0; i<matrix.length; i++) {
			for (int j=0; j<matrix[i].length; j++) {
				int temp_row;
				int temp_col;
				boolean test = false;
				boolean test2 = false;
				for (int q =0; q <col_array.length; q++) {
					temp_row = row_array[q];
					temp_col = col_array[q];
					if ((i+1)==temp_row) {
						if ((j+1)==temp_col) {
							if (test2 == false) {
								System.out.print("*");
								test2 = true;
							}
							test = true;
						}
					}
				}
				if (test==false) {
					System.out.print(".");
				}
			}
			System.out.print("\n");
		}
		
		
		
//		int column = 3;
//		int row_length = 10;
//		int new_column;
//		if (column > row_length/2) {
//			new_column =  row_length/2 - (column-row_length/2)+1;
//		}
//		else {
//			new_column = row_length/2 + (row_length/2-column)+1;
//		}
//		System.out.println(new_column);
	}

}
