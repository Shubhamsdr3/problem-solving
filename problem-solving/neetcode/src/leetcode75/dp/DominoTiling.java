package leetcode75.dp;

public class DominoTiling {

    private static int dominoTiling(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(dominoTiling(n));
    }
}
