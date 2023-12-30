package assignment7.tests.util;

import java.util.Random;

import assignment7.tests.util.StringTestUtils;
import assignment7.Student;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class StudentCourseUtils {
	public static Student[] generateUniqueStudents(int count) {
		Student[] students = new Student[count];
		for (int i = 0; i < count; ++i) {
			students[i] = new Student(String.format("F%03d", i), String.format("L%03d", i), i);
		}
		return students;
	}

	public static Student[] generateRandomStudentsWithNamesNotContainingNull(int count) {
		Random random = new Random();

		final int STRING_LENGTH = 3;
		Student[] students = new Student[count];
		int i = 0;
		while (i < count) {
			String firstName = StringTestUtils.nextRandomString(random, STRING_LENGTH);
			String lastName = StringTestUtils.nextRandomString(random, STRING_LENGTH);
			if (firstName.toLowerCase().contains("null") || lastName.toLowerCase().contains("null")) {
				// pass
			} else {
				students[i] = new Student(firstName, lastName, i);
				++i;
			}
		}
		return students;
	}

	public static Student[] generateUniqueStudentsWithRandomGradePointAverages(int count, boolean isCreditVariable) {
		Random random = new Random();
		Student[] students = generateUniqueStudents(count);
		for (Student student : students) {
			double grade = random.nextDouble() * 4.0;
			int credits = isCreditVariable ? random.nextInt(119) + 1 : 1;
			student.submitGrade(grade, credits);
		}
		return students;
	}
}
