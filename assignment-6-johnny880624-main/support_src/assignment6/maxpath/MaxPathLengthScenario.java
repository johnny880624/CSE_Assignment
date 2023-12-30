package assignment6.maxpath;

import java.util.List;
import java.util.Optional;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class MaxPathLengthScenario {
	private final String description;
	private final Optional<Integer>[][] opts;
	private final List<Cell> path;

	public MaxPathLengthScenario(String description, Optional<Integer>[][] opts, List<Cell> path) {
		this.description = description;
		this.opts = opts;
		this.path = path;
	}

	public String description() {
		return description;
	}

	public Optional<Integer>[][] opts() {
		return opts;
	}

	public List<Cell> path() {
		return path;
	}
}
