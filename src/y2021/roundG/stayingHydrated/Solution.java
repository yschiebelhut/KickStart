package y2021.roundG.stayingHydrated;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Yannik Schiebelhut
 */
public class Solution {
	static ArrayList<Integer> bottomLeftX = new ArrayList<>();
	static ArrayList<Integer> bottomLeftY = new ArrayList<>();
	static ArrayList<Integer> topRightX = new ArrayList<>();
	static ArrayList<Integer> topRightY = new ArrayList<>();

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = null;
		try {
			sc = new Scanner(new File("src/y2021.roundG/stayingHydrated/test-data/sample_test_set_1/sample_ts1_input.txt"));
//			sc = new Scanner(new File("src/y2021.roundG/stayingHydrated/test-data/test_set_1/ts1_input.txt"));
//			sc = new Scanner(new File("src/y2021.roundG/stayingHydrated/test-data/sample_test_set_1/sample_ts1_input.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		int numTests = sc.nextInt();
		for (int i = 0; i < numTests; i++) {

			int numObjects = sc.nextInt();


			for (int j = 0; j < numObjects; j++) {
				bottomLeftX.add(sc.nextInt());
				bottomLeftY.add(sc.nextInt());
				topRightX.add(sc.nextInt());
				topRightY.add(sc.nextInt());
			}

			// calculation here
			int optimalY = Integer.MIN_VALUE;

			// sort coordinate lists
			Collections.sort(bottomLeftX);
			Collections.sort(bottomLeftY);
			Collections.sort(topRightX);
			Collections.sort(topRightY);


			int optimalX = bottomLeftX.get(0);
			System.out.println(topRightX);
			System.out.println(behind(0, topRightX));
			System.out.println(behind(1, topRightX));
			System.out.println(behind(2, topRightX));
			System.out.println(behind(3, topRightX));
			System.out.println(behind(4, topRightX));
			System.out.println(behind(5, topRightX));
			while (strictAhead(optimalX, bottomLeftX) - behind(optimalX, topRightX) > 0) {
				optimalX++;
			}


			System.out.printf("Case #%d: %d %d\n", i + 1, optimalX, optimalY);
		}
	}

	private static int strictAhead(int coord, ArrayList<Integer> coords) {
		int numObjects = 0;
		while (numObjects < coords.size() && coord < coords.get(coords.size() - 1 - numObjects)) {
			numObjects++;
		}
		return numObjects;
	}

	private static int behind(int coord, ArrayList<Integer> coords) {
		int numObjects = 0;
		while (numObjects < coords.size() && coord >= coords.get(numObjects)) {
			numObjects++;
		}
		return numObjects;
	}
}
