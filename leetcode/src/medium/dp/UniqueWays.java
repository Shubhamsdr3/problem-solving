package medium.dp;

public class UniqueWays {

    private  static int[][] dp = new int[101][101];
    private static int uniquePathsUsingDp(int m, int n, int i, int j) {
        if (i >= m && j >= n) return 0;
        if (i == m -1 && j == n -1) return 1; // found the valid path.
        if (dp[i][j] >= 1) return dp[i][j];
        return dp[i][j] = uniquePathsUsingDp(m, n, i + 1, j) + uniquePathsUsingDp(m, n, i, j + 1);
    }

    private static int uniquePaths(int m , int n) {
        return uniquePathsRecursive(m , n, 0, 0);
    }

    private static int uniquePathsRecursive(int m, int n, int row, int col) {
        if (row >= m || col >= n) return 0; // reached out of bounds..invalid paths.
        if (row == m - 1 && col == n -1) return 1; // reached destination--valid path
        return uniquePathsRecursive(m, n, row + 1, col) + uniquePathsRecursive(m, n, row, col + 1); // try both down and right.
    }

    public static void main(String[] args) {
        System.out.println(uniquePathsUsingDp(3, 7, 0, 0));
    }
}
