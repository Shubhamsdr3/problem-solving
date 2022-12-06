package dynamicprogramming;

/**
 * String1 = abcdefghij
 * string2 = cdghi
 */
public class LongestCommonSubsequence {

    /**
     * LCS problem using Recursion.
     *
     * @param str1: The string in which we have to find the substring.
     * @param str2: The string
     * @param i:    The length of first string
     * @param j:    The lengh of second string
     * @return : the LCS length.
     */
    private static int findLCSLengthUsingRecursion(String str1, String str2, int i, int j) {
        if (i == 0 || j == 0) return 0;
        if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            return 1 + findLCSLengthUsingRecursion(str1, str2, i - 1, j - 1);
        } else {
            return Math.max(findLCSLengthUsingRecursion(str1, str2, i, j - 1), findLCSLengthUsingRecursion(str1, str2, i - 1, j));
        }
    }

    /**
     * LCS using Dynamic Programming.
     * @param str1 : The first leetcode.string.
     * @param str2 :  The second leetcode.string.
     * @param m:
     * @param n    Time complexity: O(m * n)
     * @return
     */
    private static int findLCSUsingDp(String str1, String str2, int m, int n) {
        int[][] memo = new int[m + 1][n + 1]; // Stores the result of repeated terms.
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    memo[i][j] = 0; // initialize with zero
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // if diagonal elements are equal
                    memo[i][j] = 1 + memo[i - 1][j - 1];
                } else {
                    memo[i][j] = Math.max(memo[i - 1][j], memo[i][j - 1]);
                }
            }
        }
        return memo[m][n];
    }

    public static void main(String[] args) {
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";
        System.out.println(findLCSUsingDp(str1, str2, str1.length(), str2.length()));
        System.out.println(findLCSLengthUsingRecursion(str1, str2, str1.length(), str2.length()));
    }

}
