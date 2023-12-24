package interviewprep_23.dp;

public class ClimbingStairs {

    /**
     * The idea is to reach nth step , we need to combine (n-1)th + (n-2)th ways.
     * somewhat like fibonacci series.
     * @param n
     * @return
     */
    private static int climbStairs(int n) {
        if (n < 0) return 0;
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

    /**
     * @param n
     * @return
     */
    private static int climbStairsUsingRecursion(int n) {
        if (n < 0) return 0;
        if (n == 0 || n ==1) return 1;
        return climbStairsUsingRecursion(n -1) + climbStairsUsingRecursion(n - 2);
    }

    /**
     * Using Dynamic programming...
     * @param n
     * @return
     */
    private static int climbStairsUsingDp(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i -2];
        }
        return memo[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairsUsingDp(n));
    }
}
