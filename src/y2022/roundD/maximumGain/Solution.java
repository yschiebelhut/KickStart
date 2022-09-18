package y2022.roundD.maximumGain;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();
        for (int curTest = 1; curTest <= numTests; curTest++) {
            int n = sc.nextInt();
            ArrayList<Integer> first = new ArrayList<>();
//            int[] first = new int[n];
            for (int i = 0; i < n; i++) {
                first.add(sc.nextInt());
//                first[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            ArrayList<Integer> second = new ArrayList<>();
//            int[] second = new int[m];
            for (int i = 0; i < m; i++) {
                second.add(sc.nextInt());
//                second[i] = sc.nextInt();
            }
            int k = sc.nextInt();

            long sum = 0;
            for (int i = 0; i < k; i++) {
                int curMax = 0;
                int curMaxPos = 0;
                if (first.size() > 0) {
                    curMax = first.get(0);
                    curMaxPos = 11;
                }
                if (first.size() > 1 && first.get(first.size()-1) > curMax) {
                    curMax = first.get(first.size()-1);
                    curMaxPos = 12;
                }
                if (second.size() > 0 && second.get(0) > curMax) {
                    curMax = second.get(0);
                    curMaxPos = 21;
                }
                if (second.size() > 1 && second.get(second.size()-1) > curMax) {
                    curMax = second.get(second.size()-1);
                    curMaxPos = 22;
                }

                sum += curMax;
                switch (curMaxPos) {
                    case 11 -> first.remove(0);
                    case 12 -> first.remove(first.size() - 1);
                    case 21 -> second.remove(0);
                    case 22 -> second.remove(second.size() - 1);
                    default -> throw new RuntimeException("something is fucked up");
                }
            }

            System.out.printf("Case #%d: %d\n", curTest, sum);
        }
    }
}
