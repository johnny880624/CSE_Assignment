package assignment6.maxpath.gui;

import java.util.Optional;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class MaxPaths {
	static Optional<Integer>[][] toEmpties(boolean[][] stones) {
		@SuppressWarnings("unchecked")
		Optional<Integer>[][] result = new Optional[stones.length][stones[0].length];
		for (int r = 0; r < result.length; ++r) {
			for (int c = 0; c < result[r].length; ++c) {
				result[r][c] = Optional.empty();
			}
		}
		return result;
	}

	static <C extends AbstractCellComponent> boolean[][] toStones(C[][] matrix) {
		boolean[][] stones = new boolean[matrix.length][matrix[0].length];
		for (int r = 0; r < stones.length; ++r) {
			for (int c = 0; c < stones[r].length; ++c) {
				stones[r][c] = matrix[r][c].isStone();
			}
		}
		return stones;
	}
}
