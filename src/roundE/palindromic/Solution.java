package roundE.palindromic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yannik Schiebelhut
 */
public class Solution {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int numTests = sc.nextInt();
			for (int i = 0; i < numTests; i++) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				char[][] puzzle = new char[n][m];
				for (int j = 0; j < n; j++) {
					String line = sc.next();
					for (int k = 0; k < line.length(); k++) {
						puzzle[j][k] = line.charAt(k);
					}
				}
				printPuzzle(puzzle);
				System.out.println("input");
				System.out.println(puzzleToString(puzzle));
				System.out.println(Arrays.toString(findLongestWordInLine(puzzle[0])));
				System.out.println(Arrays.toString(findLongestWordInLine(puzzle[1])));
				System.out.println(Arrays.toString(findLongestWordInColumn(puzzle, 0)));
				System.out.println(Arrays.toString(findLongestWordInColumn(puzzle, 1)));
				System.out.println("completion in progress");

				completePuzzle(puzzle);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static char[][] completePuzzle(char[][] puzzle) {
		return puzzle;
	}

	public static void printPuzzle(char[][] puzzle) {
		for (char[] chars : puzzle) {
			System.out.println(Arrays.toString(chars));
		}
	}

	public static String puzzleToString(char[][] puzzle) {
		StringBuilder output = new StringBuilder();
		for (char[] chars : puzzle) {
			output.append(new String(chars));
			output.append("\n");
		}
		return output.toString();
	}

	public static int[] findLongestWordInLine(char[] line) {
		ArrayList<ArrayList<Character>> words = new ArrayList<>();
		words.add(new ArrayList<>());
		for (char c : line) {
			if (c != '#') {
				ArrayList<Character> curWord = words.get(words.size() - 1);
				curWord.add(c);
				words.set(words.size() - 1, curWord);
			} else {
				words.add(new ArrayList<>());
			}
		}
		int longest = 0;
		for (int i = 0; i < words.size(); i++) {
			if (words.get(i).size() > words.get(longest).size()) {
				longest = i;
			}
		}
		int begin = 0;
		for (int i = 0; i < longest; i++) {
			begin += words.get(i).size() + 1;
		}
		int end = begin + words.get(longest).size() - 1;

		return new int[]{begin, end};
	}

	public static int[] findLongestWordInColumn(char[][] puzzle, int column) {
		char[] pseudoLine = new char[puzzle.length];
		for (int i = 0; i < puzzle.length; i++) {
			pseudoLine[i] = puzzle[i][column];
		}
		return (findLongestWordInLine(pseudoLine));
	}
}
