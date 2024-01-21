package problemsolving.kadenesalgorithm;

public class BuyAndSellStocks2 {

    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxProfit = maxProfit + (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }

    /**
     * can buy : 1
     * can't buy: 0
     * @param prices
     * @return
     */
    private static int maxProfitRec(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        return helper(prices, 0, true);
    }

    private static int helper(int[] prices, int start, boolean canBuy) {
        int maxProfit = 0;
        if (start == prices.length - 1) return maxProfit;
        if (canBuy) {
            // price will deducted as I am buying the stock.
            maxProfit = Math.max(-prices[start] + helper(prices,start + 1, false), helper(prices, start + 1, true));
        } else {
            maxProfit = Math.max(prices[start] + helper(prices,start + 1, true), helper(prices, start + 1, false));
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfitRec(arr));
    }
}
