package roundG.stayingHydrated;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Yannik Schiebelhut
 */
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numTests = sc.nextInt();
		for (int i = 0; i < numTests; i++) {

			long numObjects = sc.nextInt();

			Obj room = new Obj(new Coord(0, 0), new Coord(0, 0));
			ArrayList<Obj> objects = new ArrayList<>();


			for (int j = 0; j < numObjects; j++) {
				int bottomLeftX = sc.nextInt();
				int bottomLeftY = sc.nextInt();
				int topRightX = sc.nextInt();
				int topRightY = sc.nextInt();

				if (bottomLeftX < room.bottomLeft.x) {
					room.bottomLeft.x = bottomLeftX;
				}
				if (bottomLeftY < room.bottomLeft.y) {
					room.bottomLeft.y = bottomLeftY;
				}
				if (topRightX > room.topRight.x) {
					room.topRight.x = topRightX;
				}
				if (topRightY > room.topRight.y) {
					room.topRight.y = topRightY;
				}

				objects.add(new Obj(new Coord(bottomLeftX, bottomLeftY), new Coord(topRightX, topRightY)));
			}

			long minimumDistances = -1;
			Coord optimalLocation = new Coord(0, 0);

			for (int x = room.bottomLeft.x; x <= room.topRight.x; x++) {
				for (int y = room.bottomLeft.y; y <= room.topRight.y; y++) {
					long sumWays = 0;
					for (Obj o :
							objects) {
						long distanceX = 0;
						if (x < o.bottomLeft.x || x > o.topRight.x) {
							distanceX = Math.min(Math.abs(x - o.bottomLeft.x), Math.abs(x - o.topRight.x));
						}
						long distanceY = 0;
						if (y < o.bottomLeft.y || y > o.topRight.y) {
							distanceY = Math.min(Math.abs(x - o.bottomLeft.x), Math.abs(x - o.topRight.x));
						}
						sumWays += distanceX + distanceY;
					}
					if (minimumDistances == -1 || sumWays < minimumDistances) {
						optimalLocation.x = x;
						optimalLocation.y = y;
						minimumDistances = sumWays;
					}
				}
			}
			System.out.printf("Case #%d: %d %d\n", i + 1, optimalLocation.x, optimalLocation.y);
		}
	}

	private static class Coord {
		int x, y;

		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Coord{" +
					"x=" + x +
					", y=" + y +
					'}';
		}
	}

	private static class Obj {
		Coord bottomLeft, topRight;

		public Obj(Coord bottomLeft, Coord topRight) {
			this.bottomLeft = bottomLeft;
			this.topRight = topRight;
		}

		@Override
		public String toString() {
			return "Obj{" +
					"bottomLeft=" + bottomLeft +
					", topRight=" + topRight +
					'}';
		}
	}
}
