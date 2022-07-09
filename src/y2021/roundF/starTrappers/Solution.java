package y2021.roundF.starTrappers;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Yannik Schiebelhut
 */
public class Solution {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			int numTests = sc.nextInt();
			for (int curTest = 0; curTest < numTests; curTest++) {
				ArrayList<Star> whiteStars = new ArrayList<>();
				for (int i = 0; i < sc.nextInt(); i++) {
					whiteStars.add(new Star(sc.nextInt(), sc.nextInt()));
				}
				Star blueStar = new Star(sc.nextInt(), sc.nextInt());

				float minPerimeter = 0;
				boolean possible = false;
				if (possible) {
					System.out.printf("Case #%d; %f\n", curTest, minPerimeter);
				} else {
					System.out.printf("Case #%d; %s\n", curTest, "IMPOSSIBLE");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static class Star {
		public int x, y;

		public Star(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
