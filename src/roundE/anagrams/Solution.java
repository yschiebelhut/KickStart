package roundE.anagrams;

import java.util.Scanner;

/**
 * @author Yannik Schiebelhut
 */
public class Solution {

	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int numTests = sc.nextInt();
			//LinkedList<char[]> strings = new LinkedList<>();
			for (int i = 0; i < numTests; i++) {
				String line = sc.next();
				//strings.add(line.toCharArray());
				System.out.printf("Case #%d: %s\n", i + 1, findAnagram(line));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String findAnagram(String input) {
		char[] lineArr = input.toCharArray();

		for (int i = 0; i < lineArr.length; i++) {
			if (lineArr[i] == input.charAt(i)) {
				// find next character unequal to lineArr[i]
				for (int j = 0; j < lineArr.length; j++) {
					if (lineArr[j] != lineArr[i] && lineArr[i] != input.charAt(j) && lineArr[j] != input.charAt(i)) {
						//swap characters
						char tmp = lineArr[i];
						lineArr[i] = lineArr[j];
						lineArr[j] = tmp;
						break;
					} else if (j == lineArr.length - 1) {
						return "IMPOSSIBLE";
					}
				}
			}
		}
		return new String(lineArr);
	}
}
