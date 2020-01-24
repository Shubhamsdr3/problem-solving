package dynamicprogramming;

public class LongestCommonSubsequence {

    /**
     * LCS problem using Recursion.
     * @param str1: The leetcode.string in which we have to find the substring.
     * @param str2: The leetcode.string
     * @param i: The length of first leetcode.string
     * @param j: The lengh of second leetcode.string
     * @return : the LCS length.
     */
    private static int findLCSLengthUsingRecursion(String str1, String str2, int i, int j) {
        int result = -1;
        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();
        if (i == 0 || j == 0) {
            result = 0;
        } else if (str1Array[i - 1] == str2Array[j - 1]) {
            result = 1 + findLCSLengthUsingRecursion(str1, str2, i - 1, j - 1);
        } else if (str1Array[i - 1] != str2Array[j - 1]) {
            result = Math.max(findLCSLengthUsingRecursion(str1, str2, i - 1, j),
                    findLCSLengthUsingRecursion(str1, str2, i, j - 1));
        }
        return result;
     }

    /**
     * LCS using Dynamic Programming.
     * @param str1 : The first leetcode.string.
     * @param str2 :  The second leetcode.string.
     * @param m:
     * @param n
     * @return
     */
     private static int findLCSUsingDp(String str1, String str2, int m, int n) {
         char[] x = str1.toCharArray();
         char[] y = str2.toCharArray();

         int[][] memoTable = new int[m +1][n + 1]; // Stores the result of repeated terms.
         for (int i = 0; i <= m; i++ ) {
             for (int j=0; j <= n; j ++) {
                 if (i == 0 || j ==0 ){
                     memoTable[i][j] = 0; // initialize the elements with 0.
                 } else if (x[i -1] == y[j-1]) {
                     // If diagonal element are equal
                     memoTable[i][j] =  1 + memoTable[i -1][j-1];
                 } else {
                     memoTable[i][j] = Math.max(memoTable[i -1][j] , memoTable[i][j-1]);
                 }
             }
         }
         return memoTable[m][n];
     }

     public static void main(String[] args) {
        String str1 = "ABCBDAB";
        String str2 = "BDCABA";
        System.out.println(findLCSUsingDp(str1, str2, str1.length(), str2.length()));
         System.out.println(findLCSLengthUsingRecursion(str1, str2, str1.length(), str2.length()));
     }

}
