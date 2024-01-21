package leetcode75.dp;

import java.util.Arrays;

public class UniquePaths {

    /**
     * Using DP.
     * T.C -> O(m * n)
     * S.C -> O(m * n)
     * @param m
     * @param n
     * @return
     */
    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++){
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
               dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * Top-down recursive dp.
     * @param m
     * @param n
     * @return
     */
    private static int uniquePathsDP(int m , int n) {
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        return backtrackDP(dp, m , n , 0 , 0);
    }

    private static int backtrackDP(int[][] dp, int m, int n, int r, int c) {
        if (r == m || c == n) return 0;
        if (dp[r][c] != 0) return dp[r][c]; // we have visited this node.
        int n1 = backtrackDP(dp, m , n, r + 1, c); // right
        int n2 = backtrackDP(dp, m , n, r, c + 1); // down
        dp[r][c] = n1 + n2;
        return dp[r][c];
    }

    /**
     * Using backtracking.
     * @param m
     * @param n
     * @return
     */
    private static int uniquePathsBacktracking(int m, int n) {
        return backtrack(m , n, 0, 0);
    }

    private static int backtrack(int m, int n, int r, int c) {
        if (r == m || c == n) return 0; // out of bound
        if (r == m - 1 && c == n - 1) return 1;
        int n1 = backtrack(m, n, r + 1, c);
        int n2 = backtrack(m, n, r, c + 1);
        return n1 + n2;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 7;
        System.out.println(uniquePathsBacktracking(m, n));
    }
}
