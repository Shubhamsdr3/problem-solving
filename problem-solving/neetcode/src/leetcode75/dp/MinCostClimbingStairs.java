package leetcode75.dp;

public class MinCostClimbingStairs {

    /**
     * DP : Top down
     * Space: O(n)
     * T.C -> O(n)
     * @param cost
     * @return
     */
    private static int minCostClimbingStairsDP(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        return Math.min(minCostDp(cost, n -1, dp), minCostDp(cost, n - 2, dp));
    }

    private static int minCostDp(int[] cost, int n, int[] dp) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return cost[n];
        if (dp[n] != 0) return dp[n];
        dp[n] = cost[n] + Math.min(minCostDp(cost, n - 1, dp), minCostDp(cost, n - 2, dp));
        return dp[n];
    }

    /**
     * Recurrence relation:
     * minCost[i] = cost[i] + Math.min(mincost(i -1), mincost(i-2))
     * base case:
     * mincost(0) = cost(0)
     * mincost(1) = cost(1)
     * @param cost
     * @return
     */
    private static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        return Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    private static int minCost(int[] cost, int n) {
        if (n < 0) return 0;
        if (n == 0 || n == 1) return cost[n];
        return cost[n] + Math.min(minCost(cost, n - 1), minCost(cost, n - 2));
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };

        int[] arr1 = new int[] { 10, 15, 20 };
        System.out.println(minCostClimbingStairsDP(arr));
    }
}
