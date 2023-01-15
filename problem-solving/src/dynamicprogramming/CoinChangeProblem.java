package dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class CoinChangeProblem {

    /**
     * Find in minimum no of coins to make the money using DP..
     * @param money
     * @param arr
     * @return
     */
    private static int minWaysToMakeMoneyUsingDp(int money, int[] arr) {
        if (money == 0) return 0;
        int ans = Integer.MAX_VALUE;
        int[] dp = new int[money + 1];
        Arrays.fill(dp, -1);
        for (int i = 0; i < arr.length; i++) {
            if (money - arr[i] >= 0) { // there coins that needs to be added.
                int subAns;
                if (dp[money - arr[i]] != -1) {
                    subAns = dp[money - arr[i]]; // see if that sub-problems are already solved.
                } else {
                    subAns = minWaysToMakeMoney(money - arr[i], arr); // otherwise recurse.
                }
                if (subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
                    ans = subAns + 1;
                }
            }
        }
        dp[money] = ans; // add values to dp.
        return ans;
    }

    /**
     * Find in minimum no of coins to make the money.
     * T.C -> O(m^n) m -> no of coins.
     * @param money
     * @param arr
     * @return
     */
    private static int minWaysToMakeMoney(int money, int[] arr) {
        if (money == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (money - arr[i] >= 0) {
                int subAns = minWaysToMakeMoney(money - arr[i], arr);
                if (subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
                    ans = subAns + 1;
                }
            }
        }
        return ans;
    }

    private static long getWays(int money, int[] coins) {
        return makeChanges(money, coins, 0, new HashMap<>());
    }
    /**
     * This is called Top-Down memoization is DP method.
     * @param money: To make change.
     * @param coins: The units of coins.
     * @param indexOfCoin:
     * @param memoMap : To store the memoization value using key.
     * @return : number of ways coins can make the change of amount @param: money.
     */
    private static long makeChanges(int money, int[] coins, int indexOfCoin, HashMap<String, Long> memoMap) {
        //TODO: There is some bug in this will fix later.
        // Base case:
        if (money == 0) {
            return 1;
        }
        if (indexOfCoin > coins.length) {
            return 0;
        }
        String key = money + "_" + indexOfCoin;
        if (memoMap.containsKey(key)) {
            return memoMap.get(key);
        }

        int amountWithCoin = 0;
        long ways = 0;
        if (amountWithCoin <= money) {
            int remaining = money - amountWithCoin;
            ways =  ways + makeChanges(remaining, coins, indexOfCoin +1, memoMap);
        }
        memoMap.put(key, ways);
        return ways;
    }

    /**
     * This is called bottom up method of DP.
     * @param n: the amount of money to make change.
     * @param coins:  The number of coins with their units.
     * @return : number of ways coins can make the change of amount @param: n.
     */
    private static int maxCoins(int n, int[]coins){
        int[] results = new int[n + 1];
        results[0] = 1;
        for (int coin : coins) {
            for (int j = coin; j <= n; j++) {
                results[j] = results[j] + results[j - coin];
            }
        }
        return results[n];
    }

    private static int maxCoins1(int n, List<Long> coins){
        int[] results = new int[n + 1];
        results[0] = 1;
        for (Long coin : coins) {
            for (int j = Math.toIntExact(coin); j <= n; j++) {
                results[j] = results[j] + results[(int) (j - coin)];
            }
        }
        return results[n];
    }

    public static void main(String[] args) {
        System.out.println(minWaysToMakeMoneyUsingDp(18, new int[]{7, 5, 1}));
    }

}
