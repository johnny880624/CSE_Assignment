package assignment6;

public class test {
	
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
	
	
	public static double exponent(int base, int exp) {
		
		// FIXME Recursively compute base^exp
		if (exp ==0) {
			return 1.0;
		}
		else {
			if (exp > 0) {
				return base * exponent(base, exp-1);
				
			}
			else {
				return (1.0/base) *  exponent(base, exp+1);
			}
		}
		
}
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


//public static int maxPathLength(boolean[][] chart, int r, int c) {
//	
//	// FIXME Find and return the length of the longest path in the array
//	int value_count = 0;
//	return maxPathLength_helper(chart, r, c, value_count);
//	
//}
//
//public static int maxPathLength_helper(boolean[][] chart, int r, int c, int value_count) {
//	if (chart[r][c] == false) {
//		return value_count;
//	}
//	else {
//		chart[r][c]= false;
//		int max =0;
//		int A = 0;
//		int B = 0;
//		int C = 0;
//		int D = 0;
//		if (r-1 >=0) {
//			A =maxPathLength_helper(chart, r-1, c, value_count+1); // up
//		}
//		if (r+1 < chart.length) {
//			B =maxPathLength_helper(chart, r+1, c, value_count+1); // down
//		
//		}
//		if (c-1 >= 0) {
//			C =maxPathLength_helper(chart, r, c-1, value_count+1); // left
//		
//		}
//		if (c+1 < chart[0].length) {
//			D = maxPathLength_helper(chart, r, c+1, value_count+1); // right
//			
//		}
//		return max = Math.max(Math.max(A, B), Math.max(C, D));
//	}
//
//}
    public static String dragon1(int n) {
    	if (n > 0) {
    		String text1 = substituteAll(dragon1(n-1), 'F', "F-a");
    		text1 = substituteAll(text1, 'H', "F+H");
    		text1 = substituteAll(text1, 'a', "H");
    		return text1;
    	}
    	else {
    		return "F-H";
    	}
    }

	public static void main(String[] args) {
		System.out.println(dragon1(3));
//		// TODO Auto-generated method stub
////		System.out.println(exponent(2,-2));
////		System.out.println(dragon(3));
//		boolean[][] chart = {{true, false, false, false},
//							{true, true, true, true},
//							{false, false, true, false},
//							{false, false, true, false}};
//	    boolean[][] chart = {
//        {true, false, false, false, false},
//        {true, true, true, true, true},
//        {true, false, true, false, false},
//        {true, false, false, false, false},
//        {true, false, false, false, false}
//    };
//	    boolean[][] chart = {
//	            {false, false, true, false, false},
//	            {false, false, true, false, false},
//	            {false, true, true, true, false},
//	            {false, false, true, false, false},
//	            {false, false, false, false, false}
//	        };
//	    boolean[][] chart = {
//	            {true, true,  true,  true,  true},
//	            {false, false, true,false,  true},
//	            {false, false, true, true, true},
//	            {false, false, true, false, false},
//	            {false, false, true, false, false}
//	        };
//		System.out.println(maxPathLength(chart, 0, 0));
		
	}
	
	public static int maxPathLength(boolean[][] chart, int r, int c) {
	    // Find and return the length of the longest path in the array
	    int value_count = 0;
	    return maxPathLength_helper(chart, r, c, value_count);
	}

	public static int maxPathLength_helper(boolean[][] chart, int r, int c, int value_count) {
		// First four conditions make sure we are not out of boundary
		// Last one checks whether the path is safe or not. For example, if the next step is false, (!chart[r][c] will turn the value to true
		// and then stop proceed. 
	    if (r < 0 || r >= chart.length || c < 0 || c >= chart[0].length || !chart[r][c]) {
	        return value_count;
	    }
	    
	    // We have to turn the path we passed by to the false, in order to prevent going back to the original direction.
	    chart[r][c] = false;
	    
	    // Every time we have 4 direction to choose.
	    int A = maxPathLength_helper(chart, r-1, c, value_count+1); // up
	    int B = maxPathLength_helper(chart, r+1, c, value_count+1); // down
	    int C = maxPathLength_helper(chart, r, c-1, value_count+1); // left
	    int D = maxPathLength_helper(chart, r, c+1, value_count+1); // right
	    
	    // return the path back to true for revisiting for other routes.
	    chart[r][c] = true;

	    return Math.max(Math.max(A, B), Math.max(C, D));
	}
//
//	public static void main(String[] args) {
//	    boolean[][] chart = {
//	        {true, false, false, false, false},
//	        {true, true, true, true, true},
//	        {true, false, true, false, false},
//	        {true, false, false, false, false},
//	        {true, false, false, false, false}
//	    };
//
//	    System.out.println(maxPathLength(chart, 0, 0));
//	    System.out.println(!chart[0][1]);
//	}


}
