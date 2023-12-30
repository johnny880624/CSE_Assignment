package assignment6.maxpath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import assignment6.RecursiveMethods;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@SuppressWarnings("unchecked")
public class MaxPathLengthScenarios {
	// static Map<String, Optional<Integer>[][]> map = new LinkedHashMap<>();
	static Map<String, MaxPathLengthScenario> map = new LinkedHashMap<>();
	static {
		map.put("1X1;r=0;c=0;[.]",
				new MaxPathLengthScenario("lone chasm 1x1", new Optional[][] { { Optional.of(0) } }, Arrays.asList()));
		map.put("1X1;r=0;c=0;[*]", new MaxPathLengthScenario("lone stone 1x1", new Optional[][] { { Optional.of(1) } },
				Arrays.asList(new Cell(0, 0))));
		map.put("2X2;r=0;c=0;[*.][..]",
				new MaxPathLengthScenario("lone stone 2x2",
						new Optional[][] { { Optional.of(1), Optional.of(0) }, { Optional.of(0), Optional.empty() } },
						Arrays.asList(new Cell(0, 0))));
		map.put("5X5;r=2;c=2;[.....][.....][.....][.....][.....]",
				new MaxPathLengthScenario("empty 5x5", new Optional[][] {
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.empty(), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty() } },
						Arrays.asList()));
		map.put("5X5;r=2;c=2;[.....][.....][..*..][.....][.....]",
				new MaxPathLengthScenario("lone stone center 5x5", new Optional[][] {
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.empty(), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(1), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.empty(), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty() } },
						Arrays.asList(new Cell(2, 2))));
		map.put("5X5;r=2;c=2;[.....][..*..][..*..][.....][.....]",
				new MaxPathLengthScenario("2 stones north 5x5", new Optional[][] {
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.empty(), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(1), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(2), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.empty(), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty() } },
						Arrays.asList(new Cell(2, 2), new Cell(1, 2))));
		map.put("5X5;r=2;c=2;[.....][.....][..**.][.....][.....]",
				new MaxPathLengthScenario("2 stones east 5x5", new Optional[][] {
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(2), Optional.of(1), Optional.of(0) },
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty() } },
						Arrays.asList(new Cell(2, 2), new Cell(2, 3))));
		map.put("5X5;r=2;c=2;[.....][.....][..*..][..*..][.....]",
				new MaxPathLengthScenario("2 stones south 5x5", new Optional[][] {
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.empty(), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(2), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(1), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.empty(), Optional.empty() } },
						Arrays.asList(new Cell(2, 2), new Cell(3, 2))));
		map.put("5X5;r=2;c=2;[.....][.....][.**..][.....][.....]",
				new MaxPathLengthScenario("2 stones west 5x5", new Optional[][] {
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(0), Optional.empty(), Optional.empty() },
						{ Optional.of(0), Optional.of(1), Optional.of(2), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(0), Optional.empty(), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty() } },
						Arrays.asList(new Cell(2, 2), new Cell(2, 1))));
		map.put("5X5;r=2;c=2;[..*..][..*..][.***.][..*..][.....]", new MaxPathLengthScenario("sword north 5x5",
				new Optional[][] {
						{ Optional.empty(), Optional.of(0), Optional.of(1), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(2), Optional.of(0), Optional.empty() },
						{ Optional.of(0), Optional.of(1), Optional.of(3), Optional.of(1), Optional.of(0) },
						{ Optional.empty(), Optional.of(0), Optional.of(1), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.empty(), Optional.empty() } },
				Arrays.asList(new Cell(2, 2), new Cell(1, 2), new Cell(0, 2))));
		map.put("5X5;r=2;c=2;[.....][..*..][.****][..*..][.....]",
				new MaxPathLengthScenario("sword east 5x5", new Optional[][] {
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.empty(), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(1), Optional.of(0), Optional.of(0) },
						{ Optional.of(0), Optional.of(1), Optional.of(3), Optional.of(2), Optional.of(1) },
						{ Optional.empty(), Optional.of(0), Optional.of(1), Optional.of(0), Optional.of(0) },
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.empty(), Optional.empty() } },
						Arrays.asList(new Cell(2, 2), new Cell(2, 3), new Cell(2, 4))));
		map.put("5X5;r=2;c=2;[.....][..*..][.***.][..*..][..*..]",
				new MaxPathLengthScenario("sword south 5x5", new Optional[][] {
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.empty(), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(1), Optional.of(0), Optional.empty() },
						{ Optional.of(0), Optional.of(1), Optional.of(3), Optional.of(1), Optional.of(0) },
						{ Optional.empty(), Optional.of(0), Optional.of(2), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(1), Optional.of(0), Optional.empty() } },
						Arrays.asList(new Cell(2, 2), new Cell(3, 2), new Cell(4, 2))));
		map.put("5X5;r=2;c=2;[.....][..*..][****.][..*..][.....]",
				new MaxPathLengthScenario("sword west 5x5", new Optional[][] {
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.empty(), Optional.empty() },
						{ Optional.of(0), Optional.of(0), Optional.of(1), Optional.of(0), Optional.empty() },
						{ Optional.of(1), Optional.of(2), Optional.of(3), Optional.of(1), Optional.of(0) },
						{ Optional.of(0), Optional.of(0), Optional.of(1), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.empty(), Optional.empty() } },
						Arrays.asList(new Cell(2, 2), new Cell(2, 1), new Cell(2, 0))));
		map.put("5X5;r=4;c=2;[.....][.....][****.][..*..][..*..]",
				new MaxPathLengthScenario("up fork left", new Optional[][] {
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty() },
						{ Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(0), Optional.empty() },
						{ Optional.of(1), Optional.of(2), Optional.of(3), Optional.of(1), Optional.of(0) },
						{ Optional.of(0), Optional.of(0), Optional.of(4), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(5), Optional.of(0), Optional.empty() } },
						Arrays.asList(new Cell(4, 2), new Cell(3, 2), new Cell(2, 2), new Cell(2, 1), new Cell(2, 0))));
		map.put("5X5;r=4;c=2;[.....][....*][*****][..*..][..*..]",
				new MaxPathLengthScenario("up fork right and up", new Optional[][] {
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.of(0) },
						{ Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(1) },
						{ Optional.of(1), Optional.of(2), Optional.of(4), Optional.of(3), Optional.of(2) },
						{ Optional.of(0), Optional.of(0), Optional.of(5), Optional.of(0), Optional.of(0) },
						{ Optional.empty(), Optional.of(0), Optional.of(6), Optional.of(0), Optional.empty() } },
						Arrays.asList(new Cell(4, 2), new Cell(3, 2), new Cell(2, 2), new Cell(2, 3), new Cell(2, 4),
								new Cell(1, 4))));
		map.put("5X5;r=4;c=2;[*....][*...*][*****][..*..][..*..]", new MaxPathLengthScenario(
				"up fork left and up farther",
				new Optional[][] {
						{ Optional.of(1), Optional.of(0), Optional.empty(), Optional.empty(), Optional.of(0) },
						{ Optional.of(2), Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(1) },
						{ Optional.of(3), Optional.of(4), Optional.of(5), Optional.of(3), Optional.of(2) },
						{ Optional.of(0), Optional.of(0), Optional.of(6), Optional.of(0), Optional.of(0) },
						{ Optional.empty(), Optional.of(0), Optional.of(7), Optional.of(0), Optional.empty() } },
				Arrays.asList(new Cell(4, 2), new Cell(3, 2), new Cell(2, 2), new Cell(2, 1), new Cell(2, 0),
						new Cell(1, 0), new Cell(0, 0))));
		map.put("5X5;r=2;c=0;[..*..][..*..][***..][..*..][.....]", new MaxPathLengthScenario("fork right and up",
				new Optional[][] {
						{ Optional.empty(), Optional.of(0), Optional.of(1), Optional.of(0), Optional.empty() },
						{ Optional.of(0), Optional.of(0), Optional.of(2), Optional.of(0), Optional.empty() },
						{ Optional.of(5), Optional.of(4), Optional.of(3), Optional.of(0), Optional.empty() },
						{ Optional.of(0), Optional.of(0), Optional.of(1), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.empty(), Optional.empty() } },
				Arrays.asList(new Cell(2, 0), new Cell(2, 1), new Cell(2, 2), new Cell(1, 2), new Cell(0, 2))));
		map.put("5X5;r=2;c=0;[..*..][..*..][***..][..*..][..**.]",
				new MaxPathLengthScenario("fork right and down and right",
						new Optional[][] {
								{ Optional.empty(), Optional.of(0), Optional.of(1), Optional.of(0), Optional.empty() },
								{ Optional.of(0), Optional.of(0), Optional.of(2), Optional.of(0), Optional.empty() },
								{ Optional.of(6), Optional.of(5), Optional.of(4), Optional.of(0), Optional.empty() },
								{ Optional.of(0), Optional.of(0), Optional.of(3), Optional.of(0), Optional.empty() },
								{ Optional.empty(), Optional.of(0), Optional.of(2), Optional.of(1), Optional.of(0) } },
						Arrays.asList(new Cell(2, 0), new Cell(2, 1), new Cell(2, 2), new Cell(3, 2), new Cell(4, 2),
								new Cell(4, 3))));
		map.put("5X5;r=2;c=0;[..***][..*..][***..][..*..][..**.]", new MaxPathLengthScenario(
				"fork right and up and right farther",
				new Optional[][] { { Optional.empty(), Optional.of(0), Optional.of(3), Optional.of(2), Optional.of(1) },
						{ Optional.of(0), Optional.of(0), Optional.of(4), Optional.of(0), Optional.of(0) },
						{ Optional.of(7), Optional.of(6), Optional.of(5), Optional.of(0), Optional.empty() },
						{ Optional.of(0), Optional.of(0), Optional.of(3), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(2), Optional.of(1), Optional.of(0) } },
				Arrays.asList(new Cell(2, 0), new Cell(2, 1), new Cell(2, 2), new Cell(1, 2), new Cell(0, 2),
						new Cell(0, 3), new Cell(0, 4))));
		map.put("5X5;r=0;c=2;[..*..][..*..][.****][.....][.....]", new MaxPathLengthScenario("fork down and right",
				new Optional[][] {
						{ Optional.empty(), Optional.of(0), Optional.of(5), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(4), Optional.of(0), Optional.of(0) },
						{ Optional.of(0), Optional.of(1), Optional.of(3), Optional.of(2), Optional.of(1) },
						{ Optional.empty(), Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(0) },
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty() } },
				Arrays.asList(new Cell(0, 2), new Cell(1, 2), new Cell(2, 2), new Cell(2, 3), new Cell(2, 4))));
		map.put("5X5;r=0;c=2;[..*..][..*..][*****][*....][.....]", new MaxPathLengthScenario(
				"fork down and left and down",
				new Optional[][] {
						{ Optional.empty(), Optional.of(0), Optional.of(6), Optional.of(0), Optional.empty() },
						{ Optional.of(0), Optional.of(0), Optional.of(5), Optional.of(0), Optional.of(0) },
						{ Optional.of(2), Optional.of(3), Optional.of(4), Optional.of(2), Optional.of(1) },
						{ Optional.of(1), Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(0) },
						{ Optional.of(0), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty() } },
				Arrays.asList(new Cell(0, 2), new Cell(1, 2), new Cell(2, 2), new Cell(2, 1), new Cell(2, 0),
						new Cell(3, 0))));
		map.put("5X5;r=0;c=2;[..*..][..*..][*****][*...*][....*]", new MaxPathLengthScenario(
				"fork down and right and down farther",
				new Optional[][] {
						{ Optional.empty(), Optional.of(0), Optional.of(7), Optional.of(0), Optional.empty() },
						{ Optional.of(0), Optional.of(0), Optional.of(6), Optional.of(0), Optional.of(0) },
						{ Optional.of(2), Optional.of(3), Optional.of(5), Optional.of(4), Optional.of(3) },
						{ Optional.of(1), Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(2) },
						{ Optional.of(0), Optional.empty(), Optional.empty(), Optional.of(0), Optional.of(1) } },
				Arrays.asList(new Cell(0, 2), new Cell(1, 2), new Cell(2, 2), new Cell(2, 3), new Cell(2, 4),
						new Cell(3, 4), new Cell(4, 4))));
		map.put("5X5;r=2;c=4;[..*..][..*..][..***][..*..][.....]", new MaxPathLengthScenario("left and up",
				new Optional[][] {
						{ Optional.empty(), Optional.of(0), Optional.of(1), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(2), Optional.of(0), Optional.of(0) },
						{ Optional.empty(), Optional.of(0), Optional.of(3), Optional.of(4), Optional.of(5) },
						{ Optional.empty(), Optional.of(0), Optional.of(1), Optional.of(0), Optional.of(0) },
						{ Optional.empty(), Optional.empty(), Optional.of(0), Optional.empty(), Optional.empty() } },
				Arrays.asList(new Cell(2, 4), new Cell(2, 3), new Cell(2, 2), new Cell(1, 2), new Cell(0, 2))));
		map.put("5X5;r=2;c=4;[..*..][..*..][..***][..*..][.**..]",
				new MaxPathLengthScenario("fork left and down and left",
						new Optional[][] {
								{ Optional.empty(), Optional.of(0), Optional.of(1), Optional.of(0), Optional.empty() },
								{ Optional.empty(), Optional.of(0), Optional.of(2), Optional.of(0), Optional.of(0) },
								{ Optional.empty(), Optional.of(0), Optional.of(4), Optional.of(5), Optional.of(6) },
								{ Optional.empty(), Optional.of(0), Optional.of(3), Optional.of(0), Optional.of(0) },
								{ Optional.of(0), Optional.of(1), Optional.of(2), Optional.of(0), Optional.empty() } },
						Arrays.asList(new Cell(2, 4), new Cell(2, 3), new Cell(2, 2), new Cell(3, 2), new Cell(4, 2),
								new Cell(4, 1))));

		map.put("5X5;r=2;c=4;[***..][..*..][..***][..*..][.**..]", new MaxPathLengthScenario(
				"fork left and up and left farther",
				new Optional[][] { { Optional.of(1), Optional.of(2), Optional.of(3), Optional.of(0), Optional.empty() },
						{ Optional.of(0), Optional.of(0), Optional.of(4), Optional.of(0), Optional.of(0) },
						{ Optional.empty(), Optional.of(0), Optional.of(5), Optional.of(6), Optional.of(7) },
						{ Optional.empty(), Optional.of(0), Optional.of(3), Optional.of(0), Optional.of(0) },
						{ Optional.of(0), Optional.of(1), Optional.of(2), Optional.of(0), Optional.empty() } },
				Arrays.asList(new Cell(2, 4), new Cell(2, 3), new Cell(2, 2), new Cell(1, 2), new Cell(0, 2),
						new Cell(0, 1), new Cell(0, 0))));
		map.put("5X6;r=0;c=0;[**....][.**...][..***.][.**.*.][......]",
				new MaxPathLengthScenario("short branch",
						new Optional[][] {
								{ Optional.of(8), Optional.of(7), Optional.of(0), Optional.empty(), Optional.empty(),
										Optional.empty() },
								{ Optional.of(0), Optional.of(6), Optional.of(5), Optional.of(0), Optional.of(0),
										Optional.empty() },
								{ Optional.empty(), Optional.of(0), Optional.of(4), Optional.of(3), Optional.of(2),
										Optional.of(0) },
								{ Optional.of(0), Optional.of(1), Optional.of(2), Optional.of(0), Optional.of(1),
										Optional.of(0) },
								{ Optional.empty(), Optional.of(0), Optional.of(0), Optional.empty(), Optional.of(0),
										Optional.empty() } },
						Arrays.asList(new Cell(0, 0), new Cell(0, 1), new Cell(1, 1), new Cell(1, 2), new Cell(2, 2),
								new Cell(2, 3), new Cell(2, 4), new Cell(3, 4))));
		map.put("5X6;r=0;c=0;[**....][.**...][..***.][..*.*.][..*.**]",
				new MaxPathLengthScenario("branch",
						new Optional[][] {
								{ Optional.of(10), Optional.of(9), Optional.of(0), Optional.empty(), Optional.empty(),
										Optional.empty() },
								{ Optional.of(0), Optional.of(8), Optional.of(7), Optional.of(0), Optional.of(0),
										Optional.empty() },
								{ Optional.empty(), Optional.of(0), Optional.of(6), Optional.of(5), Optional.of(4),
										Optional.of(0) },
								{ Optional.empty(), Optional.of(0), Optional.of(2), Optional.of(0), Optional.of(3),
										Optional.of(0) },
								{ Optional.empty(), Optional.of(0), Optional.of(1), Optional.of(0), Optional.of(2),
										Optional.of(1) } },
						Arrays.asList(new Cell(0, 0), new Cell(0, 1), new Cell(1, 1), new Cell(1, 2), new Cell(2, 2),
								new Cell(2, 3), new Cell(2, 4), new Cell(3, 4), new Cell(4, 4), new Cell(4, 5))));
		map.put("5X5;r=4;c=4;[.****][....*][..*.*][*...*][*****]", new MaxPathLengthScenario("undiscovered island",
				new Optional[][] { { Optional.of(0), Optional.of(1), Optional.of(2), Optional.of(3), Optional.of(4) },
						{ Optional.empty(), Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(5) },
						{ Optional.of(0), Optional.empty(), Optional.empty(), Optional.of(0), Optional.of(6) },
						{ Optional.of(1), Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(7) },
						{ Optional.of(2), Optional.of(3), Optional.of(4), Optional.of(5), Optional.of(8) } },
				Arrays.asList(new Cell(4, 4), new Cell(3, 4), new Cell(2, 4), new Cell(1, 4), new Cell(0, 4),
						new Cell(0, 3), new Cell(0, 2), new Cell(0, 1))));
		map.put("9X8;r=0;c=0;[********][.......*][******.*][*....*.*][*.**.*.*][*.*..*.*][*.****.*][*......*][********]",
				new MaxPathLengthScenario("spiral",
						new Optional[][] {
								{ Optional.of(44), Optional.of(43), Optional.of(42), Optional.of(41), Optional.of(40),
										Optional.of(39), Optional.of(38), Optional.of(37) },
								{ Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(0),
										Optional.of(0), Optional.of(0), Optional.of(36) },
								{ Optional.of(16), Optional.of(15), Optional.of(14), Optional.of(13), Optional.of(12),
										Optional.of(11), Optional.of(0), Optional.of(35) },
								{ Optional.of(17), Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(0),
										Optional.of(10), Optional.of(0), Optional.of(34) },
								{ Optional.of(18), Optional.of(0), Optional.of(2), Optional.of(1), Optional.of(0),
										Optional.of(9), Optional.of(0), Optional.of(33) },
								{ Optional.of(19), Optional.of(0), Optional.of(3), Optional.of(0), Optional.of(0),
										Optional.of(8), Optional.of(0), Optional.of(32) },
								{ Optional.of(20), Optional.of(0), Optional.of(4), Optional.of(5), Optional.of(6),
										Optional.of(7), Optional.of(0), Optional.of(31) },
								{ Optional.of(21), Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(0),
										Optional.of(0), Optional.of(0), Optional.of(30) },
								{ Optional.of(22), Optional.of(23), Optional.of(24), Optional.of(25), Optional.of(26),
										Optional.of(27), Optional.of(28), Optional.of(29) } },
						Arrays.asList(new Cell(0, 0), new Cell(0, 1), new Cell(0, 2), new Cell(0, 3), new Cell(0, 4),
								new Cell(0, 5), new Cell(0, 6), new Cell(0, 7), new Cell(1, 7), new Cell(2, 7),
								new Cell(3, 7), new Cell(4, 7), new Cell(5, 7), new Cell(6, 7), new Cell(7, 7),
								new Cell(8, 7), new Cell(8, 6), new Cell(8, 5), new Cell(8, 4), new Cell(8, 3),
								new Cell(8, 2), new Cell(8, 1), new Cell(8, 0), new Cell(7, 0), new Cell(6, 0),
								new Cell(5, 0), new Cell(4, 0), new Cell(3, 0), new Cell(2, 0), new Cell(2, 1),
								new Cell(2, 2), new Cell(2, 3), new Cell(2, 4), new Cell(2, 5), new Cell(3, 5),
								new Cell(4, 5), new Cell(5, 5), new Cell(6, 5), new Cell(6, 4), new Cell(6, 3),
								new Cell(6, 2), new Cell(5, 2), new Cell(4, 2), new Cell(4, 3))));
		map.put("9X8;r=0;c=0;[*****...][..*.*...][***..*.*][*.*..*.*][*.**.*.*][*.*..***][*.***..*][*......*][********]",
				new MaxPathLengthScenario("tree a",
						new Optional[][] {
								{ Optional.of(28), Optional.of(27), Optional.of(26), Optional.of(3), Optional.of(2),
										Optional.of(0), Optional.empty(), Optional.empty() },
								{ Optional.of(0), Optional.of(0), Optional.of(25), Optional.of(0), Optional.of(1),
										Optional.of(0), Optional.empty(), Optional.of(0) },
								{ Optional.of(22), Optional.of(23), Optional.of(24), Optional.of(0), Optional.of(0),
										Optional.of(1), Optional.of(0), Optional.of(1) },
								{ Optional.of(21), Optional.of(0), Optional.of(6), Optional.of(0), Optional.of(0),
										Optional.of(2), Optional.of(0), Optional.of(2) },
								{ Optional.of(20), Optional.of(0), Optional.of(5), Optional.of(1), Optional.of(0),
										Optional.of(3), Optional.of(0), Optional.of(3) },
								{ Optional.of(19), Optional.of(0), Optional.of(4), Optional.of(0), Optional.of(0),
										Optional.of(4), Optional.of(5), Optional.of(6) },
								{ Optional.of(18), Optional.of(0), Optional.of(3), Optional.of(2), Optional.of(1),
										Optional.of(0), Optional.of(0), Optional.of(7) },
								{ Optional.of(17), Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(0),
										Optional.of(0), Optional.of(0), Optional.of(8) },
								{ Optional.of(16), Optional.of(15), Optional.of(14), Optional.of(13), Optional.of(12),
										Optional.of(11), Optional.of(10), Optional.of(9) } },
						Arrays.asList(new Cell(0, 0), new Cell(0, 1), new Cell(0, 2), new Cell(1, 2), new Cell(2, 2),
								new Cell(2, 1), new Cell(2, 0), new Cell(3, 0), new Cell(4, 0), new Cell(5, 0),
								new Cell(6, 0), new Cell(7, 0), new Cell(8, 0), new Cell(8, 1), new Cell(8, 2),
								new Cell(8, 3), new Cell(8, 4), new Cell(8, 5), new Cell(8, 6), new Cell(8, 7),
								new Cell(7, 7), new Cell(6, 7), new Cell(5, 7), new Cell(5, 6), new Cell(5, 5),
								new Cell(4, 5), new Cell(3, 5), new Cell(2, 5))));
		map.put("5X5;r=0;c=2;[..*..][..*..][..***][..*.*][*****]",
				new MaxPathLengthScenario("cycle down right down left",
						new Optional[][] {
								{ Optional.empty(), Optional.of(0), Optional.of(11), Optional.of(0), Optional.empty() },
								{ Optional.empty(), Optional.of(0), Optional.of(10), Optional.of(0), Optional.of(0) },
								{ Optional.empty(), Optional.of(0), Optional.of(9), Optional.of(8), Optional.of(7) },
								{ Optional.of(0), Optional.of(0), Optional.of(7), Optional.of(0), Optional.of(6) },
								{ Optional.of(1), Optional.of(2), Optional.of(3), Optional.of(4), Optional.of(5) } },
						Arrays.asList(new Cell(0, 2), new Cell(1, 2), new Cell(2, 2), new Cell(2, 3), new Cell(2, 4),
								new Cell(3, 4), new Cell(4, 4), new Cell(4, 3), new Cell(4, 2), new Cell(4, 1),
								new Cell(4, 0))));
		map.put("5X5;r=0;c=2;[..*..][..*..][***..][*.*..][*****]",
				new MaxPathLengthScenario("cycle down left down right",
						new Optional[][] {
								{ Optional.empty(), Optional.of(0), Optional.of(11), Optional.of(0), Optional.empty() },
								{ Optional.of(0), Optional.of(0), Optional.of(10), Optional.of(0), Optional.empty() },
								{ Optional.of(7), Optional.of(8), Optional.of(9), Optional.of(0), Optional.empty() },
								{ Optional.of(6), Optional.of(0), Optional.of(7), Optional.of(0), Optional.of(0) },
								{ Optional.of(5), Optional.of(4), Optional.of(3), Optional.of(2), Optional.of(1) } },
						Arrays.asList(new Cell(0, 2), new Cell(1, 2), new Cell(2, 2), new Cell(2, 1), new Cell(2, 0),
								new Cell(3, 0), new Cell(4, 0), new Cell(4, 1), new Cell(4, 2), new Cell(4, 3),
								new Cell(4, 4))));
		map.put("5X5;r=2;c=4;[*....][*....][*****][*.*..][***..]", new MaxPathLengthScenario("cycle left down left up",
				new Optional[][] {
						{ Optional.of(1), Optional.of(0), Optional.empty(), Optional.empty(), Optional.empty() },
						{ Optional.of(2), Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(0) },
						{ Optional.of(6), Optional.of(7), Optional.of(9), Optional.of(10), Optional.of(11) },
						{ Optional.of(5), Optional.of(0), Optional.of(8), Optional.of(0), Optional.of(0) },
						{ Optional.of(4), Optional.of(3), Optional.of(2), Optional.of(0), Optional.empty() } },
				Arrays.asList(new Cell(2, 4), new Cell(2, 3), new Cell(2, 2), new Cell(3, 2), new Cell(4, 2),
						new Cell(4, 1), new Cell(4, 0), new Cell(3, 0), new Cell(2, 0), new Cell(1, 0),
						new Cell(0, 0))));
		map.put("5X5;r=2;c=4;[***..][*.*..][*****][*....][*....]", new MaxPathLengthScenario(
				"cycle left up left right down",
				new Optional[][] { { Optional.of(4), Optional.of(3), Optional.of(2), Optional.of(0), Optional.empty() },
						{ Optional.of(5), Optional.of(0), Optional.of(8), Optional.of(0), Optional.of(0) },
						{ Optional.of(6), Optional.of(7), Optional.of(9), Optional.of(10), Optional.of(11) },
						{ Optional.of(2), Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(0) },
						{ Optional.of(1), Optional.of(0), Optional.empty(), Optional.empty(), Optional.empty() } },
				Arrays.asList(new Cell(2, 4), new Cell(2, 3), new Cell(2, 2), new Cell(1, 2), new Cell(0, 2),
						new Cell(0, 1), new Cell(0, 0), new Cell(1, 0), new Cell(2, 0), new Cell(3, 0),
						new Cell(4, 0))));
		map.put("5X5;r=4;c=2;[*****][*.*..][***..][..*..][..*..]", new MaxPathLengthScenario("cycle up left up right",
				new Optional[][] { { Optional.of(5), Optional.of(4), Optional.of(3), Optional.of(2), Optional.of(1) },
						{ Optional.of(6), Optional.of(0), Optional.of(7), Optional.of(0), Optional.of(0) },
						{ Optional.of(7), Optional.of(8), Optional.of(9), Optional.of(0), Optional.empty() },
						{ Optional.of(0), Optional.of(0), Optional.of(10), Optional.of(0), Optional.empty() },
						{ Optional.empty(), Optional.of(0), Optional.of(11), Optional.of(0), Optional.empty() } },
				Arrays.asList(new Cell(4, 2), new Cell(3, 2), new Cell(2, 2), new Cell(2, 1), new Cell(2, 0),
						new Cell(1, 0), new Cell(0, 0), new Cell(0, 1), new Cell(0, 2), new Cell(0, 3),
						new Cell(0, 4))));
		map.put("5X5;r=4;c=2;[*****][..*.*][..***][..*..][..*..]", new MaxPathLengthScenario("cycle up right up left",
				new Optional[][] { { Optional.of(1), Optional.of(2), Optional.of(3), Optional.of(4), Optional.of(5) },
						{ Optional.of(0), Optional.of(0), Optional.of(7), Optional.of(0), Optional.of(6) },
						{ Optional.empty(), Optional.of(0), Optional.of(9), Optional.of(8), Optional.of(7) },
						{ Optional.empty(), Optional.of(0), Optional.of(10), Optional.of(0), Optional.of(0) },
						{ Optional.empty(), Optional.of(0), Optional.of(11), Optional.of(0), Optional.empty() } },
				Arrays.asList(new Cell(4, 2), new Cell(3, 2), new Cell(2, 2), new Cell(2, 3), new Cell(2, 4),
						new Cell(1, 4), new Cell(0, 4), new Cell(0, 3), new Cell(0, 2), new Cell(0, 1),
						new Cell(0, 0))));
		map.put("5X5;r=2;c=0;[..***][..*.*][*****][....*][....*]", new MaxPathLengthScenario(
				"cycle right up right down",
				new Optional[][] { { Optional.empty(), Optional.of(0), Optional.of(2), Optional.of(3), Optional.of(4) },
						{ Optional.of(0), Optional.of(0), Optional.of(8), Optional.of(0), Optional.of(5) },
						{ Optional.of(11), Optional.of(10), Optional.of(9), Optional.of(7), Optional.of(6) },
						{ Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(2) },
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.of(0), Optional.of(1) } },
				Arrays.asList(new Cell(2, 0), new Cell(2, 1), new Cell(2, 2), new Cell(1, 2), new Cell(0, 2),
						new Cell(0, 3), new Cell(0, 4), new Cell(1, 4), new Cell(2, 4), new Cell(3, 4),
						new Cell(4, 4))));
		map.put("5X5;r=2;c=0;[....*][....*][*****][..*.*][..***]", new MaxPathLengthScenario(
				"cycle right down right up",
				new Optional[][] {
						{ Optional.empty(), Optional.empty(), Optional.empty(), Optional.of(0), Optional.of(1) },
						{ Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(0), Optional.of(2) },
						{ Optional.of(11), Optional.of(10), Optional.of(9), Optional.of(7), Optional.of(6) },
						{ Optional.of(0), Optional.of(0), Optional.of(8), Optional.of(0), Optional.of(5) },
						{ Optional.empty(), Optional.of(0), Optional.of(2), Optional.of(3), Optional.of(4) } },
				Arrays.asList(new Cell(2, 0), new Cell(2, 1), new Cell(2, 2), new Cell(3, 2), new Cell(4, 2),
						new Cell(4, 3), new Cell(4, 4), new Cell(3, 4), new Cell(2, 4), new Cell(1, 4),
						new Cell(0, 4))));
	}

	public static List<String> scenariosAsList() {
		return new ArrayList<>(map.keySet());
	}

	public static String[] scenariosAsArray() {
		return map.keySet().toArray(new String[map.size()]);
	}

	public static String lookupDescription(String scenario) {
		return map.get(scenario).description();
	}

	public static Optional<Integer>[][] lookupOpts(String scenario) {
		return map.get(scenario).opts();
	}

	public static int lookupExpected(String scenario) {
		Optional<Integer>[][] opts = map.get(scenario).opts();
		int r0 = parseRow0(scenario);
		int c0 = parseColumn0(scenario);
		Optional<Integer> opt = opts[r0][c0];
		if (opt.isPresent()) {
			return opt.get();
		} else {
			throw new RuntimeException();
		}
	}

	public static List<Cell> lookupMaxPath(String scenario) {
		return map.get(scenario).path();
	}

	public static int parseRow0(String scenario) {
		String rText = scenario.split(";")[1];
		return Integer.parseInt(rText.substring(2));
	}

	public static int parseColumn0(String scenario) {
		String cText = scenario.split(";")[2];
		return Integer.parseInt(cText.substring(2));
	}

	public static boolean[][] parseStones(String scenario) {
		String[] texts = scenario.split(";");
		String[] dimensions = texts[0].split("X");
		int rowCount = Integer.parseInt(dimensions[0]);
		int colCount = Integer.parseInt(dimensions[1]);
		boolean[][] stones = new boolean[rowCount][colCount];
		String chartText = texts[3];
		int index = 0;
		for (int r = 0; r < stones.length; ++r) {
			++index;
			for (int c = 0; c < stones[r].length; ++c) {
				char ch = chartText.charAt(index);
				stones[r][c] = ch == '*';
				++index;
			}
			++index;
		}
		return stones;
	}

	public static int calculateActual(String scenario) {
		return RecursiveMethods.maxPathLength(parseStones(scenario), parseRow0(scenario), parseColumn0(scenario));
	}
}
