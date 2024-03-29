package problemsolving.leetcode75.dp;

public class ClimbingStairs {

    private static int climbingStairsDP(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int oneStepBefore = 2;
        int twoStepBefore = 1;
        int allWays = 0;
        for (int i = 2; i < n; i++) {
            allWays = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = allWays;
        }
        return allWays;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbingStairsDP(3));
    }
}
