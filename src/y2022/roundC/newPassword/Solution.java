package y2022.roundC.newPassword;

import java.util.Scanner;

/**
 * @author Yannik Schiebelhut
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.useDelimiter("\n");
		int numTests = sc.nextInt();

		for (int curTest = 1; curTest <= numTests; curTest++) {
			int oldLength = sc.nextInt();
			String oldPW = sc.next();

			boolean hasLength = oldLength >= 7;
			boolean hasSmall = false;
			boolean hasLarge = false;
			boolean hasDigit = false;
			boolean hasSpecial = false;

			for (int i = 0; i < oldLength; i++) {
				char curChar = oldPW.charAt(i);
				String curCharAsString = String.valueOf(curChar);
				if (curCharAsString.matches("[a-z]")) {
					hasSmall = true;
				} else if (curCharAsString.matches("[A-Z]")) {
					hasLarge = true;
				} else if (curCharAsString.matches("[0-9]")) {
					hasDigit = true;
				} else if (curCharAsString.matches("[#@*&]")) {
					hasSpecial = true;
				}
			}

			String newPW = oldPW;

			newPW += hasSmall ? "" : "a";
			newPW += hasLarge ? "" : "A";
			newPW += hasDigit ? "" : "1";
			newPW += hasSpecial ? "" : "#";

			while (newPW.length() < 7) {
				newPW += "a";
			}

			System.out.printf("Case #%d: %s\n", curTest, newPW);
		}
	}
}
