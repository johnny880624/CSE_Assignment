package assignment6;

public class RecursiveMethods {

	/**
	 * Recursively computes base ^ exponent
	 * 
	 * @param base the base - can be positive or negative
	 * @param exp  the exponent - can be positive or negative
	 * @return base ^ exponent
	 */
	public static double exponent(int base, int exp) {
		
			// FIXME Recursively compute base^exp
			if (exp ==0) { // base line
				return 1.0;
			}
			else {
				if (exp > 0) { // recursive step
					return base * exponent(base, exp-1);	
				}
				else {
					return (1.0/base) *  exponent(base, exp+1);
				}
			}	
	}

	

	/**
	 * Recursively compute the sum of elements in an array
	 * 
	 * @param array an array of integers
	 * @return the sum of the elements in values
	 */
	public static int arraySum(int[] array) {
		
			// FIXME: Recursively compute the sum of the values in an array
			int count = 0;
			return arraySum_helper(array, count);
				
	}
	
	public static int arraySum_helper(int[] array, int count) {
			if(count==array.length) { // base line
				return 0;
			}
			else {
				return array[count] + arraySum_helper(array, count +1);
			}
	}

	/**
	 * Return a new String which is the original source String with all occurrences
	 * of the target character substituted by the replacement String.
	 * 
	 * @param source      the source String
	 * @param target      the target character to be replaced
	 * @param replacement the replacement String
	 * 
	 * @return the String which results from substituting all of the target
	 *         characters in the source String with the replacement String
	 */
	public static String substituteAll(String source, char target, String replacement) {
		String result = "";
		for (int i = 0; i < source.length(); ++i) {
			char ch = source.charAt(i);
			if (ch == target) {
				result = result + replacement;
			} else {
				result = result + ch;
			}
		}
		return result;
	}

	/**
	 * Recursively computes string representations of dragon curves
	 * 
	 * @param n the desired degree of the dragon curve
	 * @return the nth dragon curve
	 */
	public static String dragon(int n) {
			// FIXME Recursively compute dragon curves
			int count = 0;
			String final_str = "F-H";
			return dragon_helper(n, count, final_str);
			
			
	}
	public static String dragon_helper(int n, int count, String final_str) {
			if (count == n) {
				return final_str;
			}
			else {
				final_str = substituteAll(final_str, 'F', "F-a");
				final_str = substituteAll(final_str, 'H', "F+H");
				final_str = substituteAll(final_str, 'a', "H");
				return dragon_helper(n, count+1, final_str);
			}
		
	}
	

	/**
	 * Finds the length of the longest path in the given 2D array from the specified
	 * start position.
	 * 
	 * @param chart 2D array of stones
	 * @param r     start position row
	 * @param c     start position column
	 * @return the length of the longest path that was found
	 */
	public static int maxPathLength(boolean[][] chart, int r, int c) {
	    // Find and return the length of the longest path in the array
	    int value_count = 0;
	    return maxPathLength_helper(chart, r, c, value_count);
	}

	public static int maxPathLength_helper(boolean[][] chart, int r, int c, int value_count) {
	    if (r < 0 || r >= chart.length || c < 0 || c >= chart[0].length || !chart[r][c]) {
	        return value_count;
	    }

	    chart[r][c] = false;

	    int A = maxPathLength_helper(chart, r-1, c, value_count+1); // up
	    int B = maxPathLength_helper(chart, r+1, c, value_count+1); // down
	    int C = maxPathLength_helper(chart, r, c-1, value_count+1); // left
	    int D = maxPathLength_helper(chart, r, c+1, value_count+1); // right
	    
	    chart[r][c] = true;

	    return Math.max(Math.max(A, B), Math.max(C, D));
	}
	
//	public static int maxPathLength_helper(boolean[][] chart, int r, int c, int value_count) {
//			if (chart[r][c] == false) {
//				return value_count;
//			}
//			else {
//				chart[r][c]= false;
//				int max =0;
//				int A = 0;
//				int B = 0;
//				int C = 0;
//				int D = 0;
//				if (r-1 >=0) {
//					A =maxPathLength_helper(chart, r-1, c, value_count+1); // up
//				}
//				if (r+1 < chart.length) {
//					B =maxPathLength_helper(chart, r+1, c, value_count+1); // down
//				
//				}
//				if (c-1 >= 0) {
//					C =maxPathLength_helper(chart, r, c-1, value_count+1); // left
//				
//				}
//				if (c+1 < chart[0].length) {
//					D = maxPathLength_helper(chart, r, c+1, value_count+1); // right
//					
//				}
//				return max = Math.max(Math.max(A, B), Math.max(C, D));
//			}
//		
//	}

}
