package assignment01;

import java.util.Scanner;
import java.lang.Math;

public class GradeCalculator {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Your name: ");
		String name = in.nextLine();
		System.out.println("Your average assignment grade: ");
		double averageAssignmentGrade = in.nextDouble();
		System.out.println("Your number of studio attended: ");
		int studiosAttend = in.nextInt();
		System.out.println("Your average quiz grade: ");
		double averageQuizGrade = in.nextDouble();
		System.out.println("Your average exam grade: ");
		double averageExamGrade = in.nextDouble();	
		
		
		double weightedAssignmentGrade = Math.round(averageAssignmentGrade * 0.36*100.0)/100.0;
		double weightedStudioGrade = Math.round( (double)studiosAttend/8* 100 * 0.1*100.0)/100.0;
		double weightedQuizGrade = Math.round(averageQuizGrade * 0.02*100.0)/100.0;
		double weightedExamGrade = Math.round(averageExamGrade * 0.54*100.0)/100.0;
		
		System.out.println("CSE131 Grade for: " + name);
		System.out.println("Average assignment grade: " + averageAssignmentGrade);
		System.out.println("Weighted assignment grade(out of 36): " + weightedAssignmentGrade + "%");
		System.out.println("Number of studios attended: " + studiosAttend);
		System.out.println("Weighted studio grade(out of 10): " + weightedStudioGrade + "%");
		System.out.println("Average quiz grade: " + averageQuizGrade);
		System.out.println("Weighted quiz grade(out of 2): " + weightedQuizGrade + "%");
		System.out.println("Average exam grade: " + averageExamGrade);
		System.out.println("Weighted exam grade(out of 54): " +weightedExamGrade + "%");
		System.out.println("Total Grade: " + ((weightedAssignmentGrade + 
				weightedStudioGrade + weightedQuizGrade + weightedExamGrade )*100.0)/100.0 + "%");
		
		
	}

}
