package strings;

import java.util.HashSet;
import java.util.Set;

public class CommonChild {

    /**
     * Brute-force solution
     * @param s1
     * @param s2
     * @return
     */
    private static int commonChild(String s1, String s2) {
        return findLCSUsingDp(s1, s2, s1.length(), s2.length());
    }

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
        String string1 = "HARRY";
        String string2 = "SALLY";

        String string3 = "SHINCHAN";
        String string4 = "NOHARAAA";

        String string5 = "ABCDEF";
        String string6 = "FBDAMN";

        String string7 = "ABCD";
        String string8 = "ABDC";
        System.out.println(commonChild(string1, string2));
        System.out.println(commonChild(string3, string4));
        System.out.println(commonChild(string5, string6));
        System.out.println(commonChild(string7, string8));
    }

}
