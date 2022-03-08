package easy;

public class ClimbingStairs {

    private static final int MIN = 1;
    private static final int MAX = 2;

    private static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            // 1+1, 2
            return 2;
        }
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

    /**
     * using Dp
     * @param n
     */
    private static int climbStairsUsingDP(int n) {
        int[] dp = new int[n +1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i -1] + dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairsUsingDP(n));
    }
}
