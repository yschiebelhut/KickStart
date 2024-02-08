package y2022.roundF.sortTheFabrics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numTests = sc.nextInt();
		for (int curTest = 1; curTest <= numTests; curTest++) {
			int n = sc.nextInt();
			ArrayList<Fabric> fabrics = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				String c = sc.next();
				int d = sc.nextInt();
				int u = sc.nextInt();
				fabrics.add(new Fabric(c, d, u));
			}

			ArrayList<Fabric> lex = new ArrayList<>(fabrics);
			lex.sort(Comparator.comparing((Fabric o) -> o.c).thenComparingInt(o -> o.u));

			ArrayList<Fabric> dur = new ArrayList<>(fabrics);
			dur.sort(Comparator.comparing((Fabric o) -> o.d).thenComparingInt(o -> o.u));

			int numEquals = 0;
			for (int i = 0; i < n; i++) {
				if (lex.get(i).equals(dur.get(i))) {
					numEquals++;
				}
			}
			System.out.printf("Case #%d: %d\n", curTest, numEquals);
		}
	}

	static class Fabric {
		String c;
		int d;
		int u;

		public Fabric(String c, int d, int u) {
			this.c = c;
			this.d = d;
			this.u = u;
		}

		public String getC() {
			return c;
		}

		public int getD() {
			return d;
		}

		public int getU() {
			return u;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Fabric fabric = (Fabric) o;
			return d == fabric.d && u == fabric.u && Objects.equals(c, fabric.c);
		}

		@Override
		public int hashCode() {
			return Objects.hash(c, d, u);
		}

		@Override
		public String toString() {
			return "Fabric{" +
					"c='" + c + '\'' +
					", d=" + d +
					", u=" + u +
					'}';
		}
	}
}
