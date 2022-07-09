package y2022.roundC.antsOnAStick;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * @author Yannik Schiebelhut
 */
public class Solution {
	private static List<Integer> drop;
	private static int[] p;
	private static int[] d;
	private static int n;
	private static int l;
	private static List<Integer> antsToCheck;

	public static void main(String[] args) throws IOException {
//		Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("src/y2022/roundC/antsOnAStick/test-data/test_set_1/ts1_input.txt"));
		int numTests = sc.nextInt();

		for (int curTest = 1; curTest <= numTests; curTest++) {
			n = sc.nextInt();
			antsToCheck = new ArrayList<>(IntStream.range(0, n).boxed().toList());
			l = sc.nextInt();

			p = new int[n];
			d = new int[n];
			for (int i = 0; i < n; i++) {
				p[i] = sc.nextInt();
				int tmpD = sc.nextInt(); // translate d
				d[i] = tmpD == 0 ? -1 : tmpD;
			}

			drop = new LinkedList<>();

			while (drop.size() < n) {
				dropAnts();
				walkAndReverse();
			}

			StringBuilder output = new StringBuilder();
			while (drop.size() > 1) {
				output.append(drop.get(0));
				output.append(" ");
				drop.remove(0);
			}
			output.append(drop.get(0));
			System.out.printf("Case #%d: %s\n", curTest, output.toString());
			PrintWriter p = new PrintWriter(new FileWriter("src/y2022/roundC/antsOnAStick/test-data/test_set_1/my_output_1.txt", true));
			p.printf("Case #%d: %s\n", curTest, output.toString());
			p.flush();
		}
	}

	private static void walkAndReverse() {
		List<Integer> tmpAntsToCheck = new ArrayList<>(List.copyOf(antsToCheck));
		while (tmpAntsToCheck.size() > 0) {
			boolean collision = false;
			for (int i = 1; i < tmpAntsToCheck.size(); i++) {
				if (p[tmpAntsToCheck.get(0)] == p[tmpAntsToCheck.get(i)]) {
					// check if ants collide in previous run
					collision = true;
					d[tmpAntsToCheck.get(0)] *= -1;
					d[tmpAntsToCheck.get(i)] *= -1;
					p[tmpAntsToCheck.get(0)] += d[tmpAntsToCheck.get(0)];
					p[tmpAntsToCheck.get(i)] += d[tmpAntsToCheck.get(i)];
					tmpAntsToCheck.remove(i);
					tmpAntsToCheck.remove(0);
					break;
				}
//				else if (p[tmpAntsToCheck.get(0)] + 0.5 * d[tmpAntsToCheck.get(0)] == p[tmpAntsToCheck.get(i)] + 0.5 *
//				d[tmpAntsToCheck.get(i)]) {
//					// check if ants collide in between full steps
//					collision = true;
//					d[tmpAntsToCheck.get(0)] *= -1;
//					d[tmpAntsToCheck.get(i)] *= -1;
//					tmpAntsToCheck.remove(i);
//					tmpAntsToCheck.remove(0);
//					break;
//				}
//				else if (p[tmpAntsToCheck.get(0)] + d[tmpAntsToCheck.get(0)] == p[tmpAntsToCheck.get(i)] +
//				d[tmpAntsToCheck.get(i)]) {
//					// check if ants collide at a full step
//					collision = true;
//					p[tmpAntsToCheck.get(0)] += d[tmpAntsToCheck.get(0)];
//					p[tmpAntsToCheck.get(i)] += d[tmpAntsToCheck.get(i)];
//					d[tmpAntsToCheck.get(0)] *= -1;
//					d[tmpAntsToCheck.get(i)] *= -1;
//					tmpAntsToCheck.remove(i);
//					tmpAntsToCheck.remove(0);
//					break;
//				}
			}
			for (int i = 1; !collision && i < tmpAntsToCheck.size(); i++) {
				if (p[tmpAntsToCheck.get(0)] + 0.5 * d[tmpAntsToCheck.get(0)] == p[tmpAntsToCheck.get(i)] + 0.5 * d[tmpAntsToCheck.get(i)]) {
					// check if ants collide in between full steps
					collision = true;
					d[tmpAntsToCheck.get(0)] *= -1;
					d[tmpAntsToCheck.get(i)] *= -1;
					tmpAntsToCheck.remove(i);
					tmpAntsToCheck.remove(0);
					break;
				}
			}
			if (!collision) {
				p[tmpAntsToCheck.get(0)] += d[tmpAntsToCheck.get(0)];
				tmpAntsToCheck.remove(0);
			}
		}
	}

	public static void dropAnts() {
		List<Integer> curDrop = new LinkedList<>();
		for (int i = antsToCheck.size() - 1; i >= 0; i--) {
			if (p[antsToCheck.get(i)] == 0 || p[antsToCheck.get(i)] == l) {
				curDrop.add(antsToCheck.get(i) + 1);
				antsToCheck.remove(i);
			}
		}
		curDrop.sort(Integer::compareTo);
		drop.addAll(curDrop);
	}
}
