package roundF.festival;

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
				int days = sc.nextInt();
				int numAttractions = sc.nextInt();
				int numAttractionsToRide = sc.nextInt();
				ArrayList<Attraction> attractions = new ArrayList<>();
				for (int i = 0; i < numAttractions; i++) {
					attractions.add(new Attraction(sc.nextInt(), sc.nextInt(), sc.nextInt()));
				}

				int maxTotalHappiness = 0;
				for (int day = 1; day <= days; day++) {
					ArrayList<Attraction> availableAttractions = new ArrayList<Attraction>();
					for (Attraction a : attractions) {
						if (day >= a.si && day <= a.ei) {
							availableAttractions.add(a);
						}
					}
					availableAttractions.sort((a, b) -> {
						return b.hi - a.hi;
					});
					int totalHappiness = 0;
					for (int i = 0; i < numAttractionsToRide; i++) {
						if (i < availableAttractions.size()) {
							totalHappiness += availableAttractions.get(i).hi;
						}
					}
					maxTotalHappiness = Math.max(maxTotalHappiness, totalHappiness);
				}

				System.out.printf("Case #%d: %d\n", curTest + 1, maxTotalHappiness);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	static class Attraction {
		public int hi, si, ei;

		public Attraction(int hi, int si, int ei) {
			this.hi = hi;
			this.si = si;
			this.ei = ei;
		}
	}
}
