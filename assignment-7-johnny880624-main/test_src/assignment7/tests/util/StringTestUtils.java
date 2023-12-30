package assignment7.tests.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Supplier;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class StringTestUtils {
	public static List<String> createStringList(String... elements) {
		return Arrays.asList(elements);
	}

	private static Set<String> createSet(Supplier<String> supplier, int length) {
		Set<String> set = new HashSet<>();
		while (set.size() < length) {
			String s = supplier.get();
			set.add(s);
		}
		return set;
	}

	public static List<String> createUniqueStringList(Supplier<String> supplier, int length) {
		Set<String> set = createSet(supplier, length);
		List<String> list = new ArrayList<>(set);
		// note: hash set should be unordered already
		Collections.shuffle(list);
		return list;
	}

	public static List<String> createUniqueSortedStringList(Supplier<String> supplier, int length) {
		Set<String> set = createSet(supplier, length);
		List<String> list = new ArrayList<>(set);
		Collections.sort(list);
		return list;
	}

	public static String[] toStringArray(List<String> strings) {
		return strings.toArray(new String[strings.size()]);
	}

	public static String nextRandomString(Random random, int characterCount) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < characterCount; i++) {
			char c = (char) ('A' + random.nextInt(26));
			sb.append(c);
		}
		return sb.toString();
	}

	public static String[] createUninspiringlyCombinedArray(String[] a, String[] b) {
		String[] result = new String[a.length + b.length];
		System.arraycopy(a, 0, result, 0, a.length);
		System.arraycopy(b, 0, result, a.length, b.length);
		Arrays.sort(result, String::compareToIgnoreCase);
		return result;
	}

	public static Collection<Object[]> createDefaultConstructorArguments() {
		Collection<Object[]> result = new LinkedList<>();
		result.add(new Object[] { StringTestUtils.createStringList(), StringTestUtils.createStringList() });
		result.add(new Object[] { StringTestUtils.createStringList("A"), StringTestUtils.createStringList() });
		result.add(new Object[] { StringTestUtils.createStringList(), StringTestUtils.createStringList("A") });
		result.add(new Object[] { StringTestUtils.createStringList("A"), StringTestUtils.createStringList("B") });
		result.add(new Object[] { StringTestUtils.createStringList("B"), StringTestUtils.createStringList("A") });
		result.add(new Object[] { StringTestUtils.createStringList("A", "B"),
				StringTestUtils.createStringList("C", "D") });
		result.add(new Object[] { StringTestUtils.createStringList("C", "D"),
				StringTestUtils.createStringList("A", "B") });
		result.add(new Object[] { StringTestUtils.createStringList("A", "C"),
				StringTestUtils.createStringList("B", "D") });
		result.add(new Object[] { StringTestUtils.createStringList("B", "E", "G"),
				StringTestUtils.createStringList("I", "N", "S") });
		result.add(new Object[] { StringTestUtils.createStringList("I", "N", "S"),
				StringTestUtils.createStringList("B", "E", "G") });
		result.add(new Object[] { StringTestUtils.createStringList("E", "G", "N"),
				StringTestUtils.createStringList("B", "I", "S") });
		return result;
	}

	public static Collection<Object[]> createExtendedConstructorArguments() {
		Collection<Object[]> result = createDefaultConstructorArguments();
		Random random = new Random();
		final int STRING_LENGTH = 3;
		for (int[] configs : new int[][] { { 5, 4 }, { 10, 7 } }) {
			int iterationCount = configs[0];
			int arrayLength = configs[1];
			for (int i = 0; i < iterationCount; i++) {
				List<String> aStrings = StringTestUtils.createUniqueSortedStringList(
						() -> StringTestUtils.nextRandomString(random, STRING_LENGTH), arrayLength);
				List<String> bStrings = StringTestUtils.createUniqueSortedStringList(
						() -> StringTestUtils.nextRandomString(random, STRING_LENGTH), arrayLength);
				result.add(new Object[] { aStrings, bStrings });
			}
		}
		return result;
	}

	private static final int DEFAULT_TO_STRING_ARRAY_LENGTH_LIMIT = 2048;

	private static String toString(String[] array, int toStringArrayLengthLimit) {
		final int ELEMENT_COUNT_WHEN_AT_LIMIT = 8;
		int limit = Math.max(toStringArrayLengthLimit, ELEMENT_COUNT_WHEN_AT_LIMIT);
		if (array != null && array.length <= limit) {
			return Arrays.toString(array);
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append("[length: ");
			sb.append(array.length);
			sb.append("; truncated_contents: [");
			for (int i = 0; i < ELEMENT_COUNT_WHEN_AT_LIMIT; i++) {
				sb.append(array[i]);
				sb.append(",");
			}
			sb.append("...]]");
			return sb.toString();
		}
	}

	public static String createMessage(String[] expected, String[] actual, int toStringArrayLengthLimit) {
		return "\nexpected:\n\t\t" + toString(expected, toStringArrayLengthLimit) + "\nactual:\n\t\t"
				+ toString(actual, toStringArrayLengthLimit) + "\n";
	}

	public static String createMessage(String[] expected, String[] actual) {
		return createMessage(expected, actual, DEFAULT_TO_STRING_ARRAY_LENGTH_LIMIT);
	}
}
