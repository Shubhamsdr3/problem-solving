package dynamicprogramming;

import java.util.HashMap;
import java.util.List;

public class CoinChangeProblem {

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
        System.out.println(getWays(4, new int[]{1, 2, 3}));
    }

}
