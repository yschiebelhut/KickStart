package y2022.roundC.rangePartition;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Yannik Schiebelhut
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numTests = sc.nextInt();

		for (int curTest = 1; curTest <= numTests; curTest++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			long[] magicRatio = calculateRatio(x, y);

			List<Integer> set = IntStream.range(0, n + 1).boxed().toList();
		}
	}

	private static long[] calculateRatio(long x, long y) {
		long[] output = new long[2];
		output[0] = x / y;
		output[1] = y - output[0];
		return output;
	}
}
