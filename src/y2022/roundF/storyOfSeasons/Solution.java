package y2022.roundF.storyOfSeasons;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numTests = sc.nextInt();
		for (int curTest = 1; curTest <= numTests; curTest++) {
			int d = sc.nextInt(); // days in warm season
			int n = sc.nextInt(); // number of kinds of vegetable seeds
			int x = sc.nextInt(); // number of seeds you can plant each day

			ArrayList<Seed> seeds = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int q = sc.nextInt();
				int l = sc.nextInt();
				int v = sc.nextInt();
				seeds.add(new Seed(q, l, v));
			}
			seeds.sort(((o1, o2) -> (int) (o2.ratio - o1.ratio)));

			int total = 0;
			for (int curDay = 1; curDay <= d; curDay++) {
				// do not consider seeds that will not ripe in the rest of the time
				for (int i = seeds.size() - 1; i > 0; i--) {
					if (seeds.get(i).l >= (d - curDay)) {
						seeds.remove(i);
					}
				}
				for (int i = 0; i < x; i++) {
					try {
						System.out.println(seeds.get(0).v);
						total += seeds.get(0).v;
						seeds.get(0).q--;
						if (seeds.get(0).q <= 0) {
							seeds.remove(0);
						}
					} catch (Exception e) {
					}
				}
			}

			System.out.printf("Case #%d: %d\n", curTest, total);
		}
	}

	static class Seed {
		int q; // quantity
		int l; // number of days it needs to mature
		int v; // retail value of a mature plant

		int ratio;

		public Seed(int q, int l, int v) {
			this.q = q;
			this.l = l;
			this.v = v;

			this.ratio = v*l;
		}
	}

	static class Plant {
		int value;
		int dayPlanted;
		int matureAge;

		public Plant(int value, int dayPlanted, int matureAge) {
			this.value = value;
			this.dayPlanted = dayPlanted;
			this.matureAge = matureAge;
		}
	}
}
