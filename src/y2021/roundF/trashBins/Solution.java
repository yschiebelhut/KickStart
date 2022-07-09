package y2021.roundF.trashBins;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Yannik Schiebelhut
 */
public class Solution {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int numTests = sc.nextInt();
			for (int curTest = 0; curTest < numTests; curTest++) {
				int numHouses = sc.nextInt();
				String bins = sc.next(); // 1 bin in front, 0 no bin in front
				int[] distance = new int[bins.length()];
				int curDistance = Integer.MAX_VALUE;
				for (int i = 0; i < bins.length(); i++) {
					if (bins.charAt(i) == '1') {
						distance[i] = 0;
						curDistance = 0;
					} else {
						if (curDistance != Integer.MAX_VALUE) {
							curDistance++;
						}
						distance[i] = curDistance;
					}
				}
				curDistance = Integer.MAX_VALUE;
				for (int i = bins.length() - 1; i >= 0; i--) {
					if (bins.charAt(i) == '1') {
						curDistance = 0;
					} else {
						if (curDistance != Integer.MAX_VALUE) {
							curDistance++;
						}
						distance[i] = Math.min(curDistance, distance[i]);
					}
				}

				long sumWays = 0;
				for (int i = 0; i < numHouses; i++) {
					sumWays += distance[i];
				}
				System.out.println(Arrays.toString(distance));

				System.out.printf("Case #%d: %d\n", curTest + 1, sumWays);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
