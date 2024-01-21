package problemsolving.kadenesalgorithm;

import java.util.Map;

public class BestTimeToBuySellStock3 {

    /**
     * @param prices
     * @return
     */
    private static int maxProfitMedium(int[] prices) {
        int totalProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            int profitSoFar = 0;
            int maxProfit = 0;
            int j = i + 1;
            int transaction = 0;
            if (transaction < 2) {
                while (j < prices.length) {
                    if (prices[j] > prices[i]) {
                        int profit = prices[j] - prices[i];
                        if (profit > profitSoFar) {
                            profitSoFar = profit;
                            i = j;
                            transaction++;
                        }
                    }
                    j++;
                }
//                maxProfit = Math.max()
            }
            totalProfit = totalProfit + profitSoFar;
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 3, 5, 0, 0, 3, 1, 4 };
        int[] arr1 = new int[] { 1, 2, 3, 4, 5 };
        int[] arr2 = new int[] {7, 6, 4, 3, 1 };
        int[] arr3 = new int[] {2, 1, 4};
        System.out.println(maxProfitMedium(arr3));
    }
}
