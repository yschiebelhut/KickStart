package roundG.dogsAndCats;

import java.util.Scanner;

/**
 * @author Yannik Schiebelhut
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numTests = sc.nextInt();
		for (int i = 0; i < numTests; i++) {

			long n = sc.nextInt();
			long d = sc.nextInt();
			long c = sc.nextInt();
			long m = sc.nextInt();
			if (n != 0) {
				String s = sc.next();

				int j = 0;
				boolean outOfFood = false;
				for (; j < s.length() && d > 0 && !outOfFood; j++) {
					switch (s.charAt(j)) {
						case 'C':
							if (c > 0) {
								c--;
							} else {
								outOfFood = true;
							}
							break;
						case 'D':
							d--;
							c += m;
							break;
					}
				}
				boolean dogLeft = false;
				for (; j < s.length(); j++) {
					if (s.charAt(j) == 'D') {
						dogLeft = true;
					}
				}
				System.out.printf("Case #%d: %s\n", i + 1, dogLeft ? "NO" : "YES");
			} else {
				System.out.printf("Case #%d: %s\n", i + 1, "YES");
			}
		}
	}
}
