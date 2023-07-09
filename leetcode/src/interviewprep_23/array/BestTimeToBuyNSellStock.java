package interviewprep_23.array;

public class BestTimeToBuyNSellStock {

    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i -1]) {
                maxProfit = maxProfit + (prices[i] - prices[i - 1]);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{ 7, 1, 5, 3, 6, 4 };
        int[] prices1 = new int[]{1, 2, 3, 4, 5 };
        System.out.println(maxProfit(prices));
    }
}
