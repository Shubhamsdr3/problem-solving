package medium;

/**
Created at: 14/12/22
*/
public class NumberOfWaysToSplitString {

    private static final int MOD = 1_000_000_007;

    private static int numWays(String s) {
        int noOfOnes = 0;
        int n = s.length();
        int[] onesIdx = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                onesIdx[noOfOnes] = i;
                noOfOnes++;
            }
        }
        if (noOfOnes == 0) { // if all the elements are zero in the array
            return (int) ((n - 2L) * (n - 1L) / 2 % MOD);
        }
        if (noOfOnes % 3 != 0) { // if number of 1s are not in multiple of 3 then return zero.
            return 0;
        }
        long waysToFirstCut = onesIdx[noOfOnes / 3] - onesIdx[noOfOnes / 3 - 1];
        long waysOfSecondCut = onesIdx[noOfOnes * 2 / 3] - onesIdx[noOfOnes * 2 / 3 - 1];
        return (int) (waysToFirstCut * waysOfSecondCut % MOD);
    }

    public static void main(String[] args) {
        String str = "10101";
        System.out.println(numWays(str));
    }
}
