package medium;

import java.util.PriorityQueue;

/**
 * Paint houses with colors Red, Green and Blue such that no two houses have the same color.
 */
public class HouseColoring {

    /**
     * Number of colors => 3 (RGB: fixed)
     * @param houses
     * @param cost
     * @return
     */
    private static long paintHouse(int houses , int[][] cost) {
        long[][] dp = new long[houses][3]; // 3 -> number of colors
        int n = cost.length;
        dp[0][0] = cost[0][0]; // for red
        dp[0][1] = cost[0][1]; // for green
        dp[0][2] = cost[0][2]; // for blue
        for (int i = 1; i < cost.length; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i -1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i -1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i -1][1]);
        }
        return Math.min(dp[n -1][0], Math.min(dp[n -1][1], dp[n-1][2]));
    }

    public static void main(String[] args) {
        int n = 4;
//        int[][] cost = new int[][] {{1, 5, 7},  {5, 8, 4}, {3, 2, 9}, {1, 2, 4}};
//        System.out.println(paintHouse(n, cost));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(1);
        pq.add(8);
        pq.add(7);
        pq.add(9);
        pq.add(6);
        pq.add(5);
        System.out.println(pq.size());
        for (int i = 0; i < pq.size(); i++) {
            System.out.println(pq.poll());
        }
    }
}
