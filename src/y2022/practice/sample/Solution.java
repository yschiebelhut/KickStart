package y2022.practice.sample;

import java.util.Scanner;

/**
 * @author Yannik Schiebelhut
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numCases = sc.nextInt();
		for (int curCase = 0; curCase < numCases; curCase++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			long sum = 0;
			for (int i = 0; i < n; i++) {
				sum += sc.nextInt();
			}
			System.out.printf("Case #%d: %d\n", curCase + 1, sum % m);
		}
	}
}
