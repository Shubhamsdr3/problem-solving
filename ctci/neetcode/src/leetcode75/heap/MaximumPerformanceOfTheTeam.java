package leetcode75.heap;

import java.util.*;

public class MaximumPerformanceOfTheTeam {

    private static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] ess = new int[n][2]; // map speed and effieciency.
        for (int i = 0; i < n; i++) {
            ess[i] = new int[] { efficiency[i], speed[i] };
        }
        Arrays.sort(ess, (a, b) -> b[0] - a[0]);
        System.out.println(ess);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        int result = 0;
        for (int[] pair: ess) {
            pq.add(pair[1]);
            sum = sum + pair[1]; // adding speed.

            if (pq.size() > k) {
                sum = sum - pq.poll(); // if we hire new one we layoff the least efficient one.
            }
            result = Math.max(result, (sum * pair[0]));
        }
        return result;
    }

    public static void main(String[] args) {
        int[] speed = new int[] { 2, 10, 3, 1, 5, 8 };
        int n = 6;
        int[] eff = new int[] { 5, 4, 3, 9, 7, 2 };
        int k = 3;


        System.out.println(maxPerformance(n, speed, eff, k));
    }
}
