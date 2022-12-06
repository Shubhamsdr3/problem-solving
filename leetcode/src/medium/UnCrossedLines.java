package medium;

public class UnCrossedLines {

    private static int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 5, 1, 2, 5};
        int[] arr2 = new int[]{10, 5, 2, 1, 5, 2};
        System.out.println(maxUncrossedLines(arr1, arr2));
    }
}
