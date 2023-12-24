package interviewprep_23.dp;

public class MaxProfit {

    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    int profit = prices[j] - prices[i];
                    maxProfit = Math.max(maxProfit, profit);
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[] { 7, 1, 5, 3, 6, 4 };
        int[] prices1 = new int[] { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(prices1));
    }
}
