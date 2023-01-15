package medium.dp;

import java.util.Vector;

/**
 * There are 100 different types of caps each having a unique id from 1 to 100.
 * Also there are n persons each having a collection of a variable number of caps.
 * One day all these persons decide to go in a party wearing a cap but to look unique they
 * decided that none of them will wear the same type of cap.
 * Count the total number of arrangements or ways such that none of them is wearing the same type of cap ?
 * 1 <= n <= 10 // n -> number of persons.
 */
public class CountWaysToAssignUniqueCap {

    private static Vector<Integer>[] capList = new Vector[101];
    private static int dp[][] = new int[1025][101];
    private static int allMask;
    private static final int MOD = 1000000007;

    /**
     * @param mask
     * @param i -> cap_id (i.e the number of caps processed starting from first cap)
     * @return
     */
    private static int numberOfWays(int mask, int i) {
        if (mask == allMask) return 1; // if all the persons are wearing cap.
        if (i >  100) return 0; // if not everyone is wearing the cap i.e there is no way.
        if (dp[mask][i] != -1) return dp[mask][i]; // if we already solved this problem..return the answer.
        long ways = numberOfWays(mask, i + 1); // ways, when we don't include this cap in our arrangement or solution yet.
        int size = capList[i].size();
        for (int j = 0; j < size; j++) {
            if ((mask & (1 << capList[i].get(j))) != 0) continue;
            else ways = ways + numberOfWays(mask | (1 << capList[i].get(j)), i + 1);
            ways = ways % MOD;
        }
        return dp[mask][i] = (int) ways;
    }

    public static void main(String[] args) {
        int numberOfPerson = 3;
        int[] firstPerson = new int[] { 5, 100, 1 };
        int[] secondPerson = new int[] { 2 };
        int[] thirdPerson = new int[] { 5, 100 };
        // output -> 4 (all possible ways ->  (5, 2, 100), (100, 2, 5), (1, 2, 5), (1, 2, 100))
    }
}
