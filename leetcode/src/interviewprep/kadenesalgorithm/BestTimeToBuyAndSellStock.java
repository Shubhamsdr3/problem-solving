package interviewprep.kadenesalgorithm;

public class BestTimeToBuyAndSellStock {


    /**
     * Medium
     * @param prices
     * @return
     */
    private static int maxProfitMedium(int[] prices) {
        int i = 1;
        int maxProfit = 0;
        while(i < prices.length) {
            if (prices[i] > prices[i -1]) {
                maxProfit = maxProfit + (prices[i] - prices[i -1]);
            }
            i++;
        }
        return maxProfit;
    }

    private static int maxProfitUsingKadanesAlgo(int[] prices) {
        int maxCurrent = 0;
        int maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCurrent = maxCurrent + prices[i] - prices[i -1];
            maxCurrent = Math.max(0, maxCurrent);
            maxSoFar = Math.max(maxCurrent, maxSoFar);
        }
        return maxSoFar;
    }

    /**
     * O(n) -> In a single pass.
     * @param prices
     * @return
     */
    private static int maxProfitInOnePass(int[] prices) {
        int lowest = Integer.MAX_VALUE;
        int currentProfit;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            }
            currentProfit = prices[i] - lowest;
            maxProfit = Math.max(currentProfit, maxProfit);
        }
        return maxProfit;
    }

    /**
     * Easy question.
     * T.C -> O(n^2)
     * @param prices
     * @return
     */
    private static int maxProfitEasy(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
            }
        }
        return maxProfit;
    }

    /**
     * Medium
     */
    private static int maxProfit(int[] prices, int fee) {
        if (prices.length <= 1) return 0;
        int days = prices.length;
        int[] buy = new int[days];
        int[] sell = new int[days];
        buy[0] = -prices[0] - fee;
        for (int i = 1; i < days; i++) {
            buy[i] = Math.max(buy[i -1], sell[i -1] - prices[i] - fee);
            sell[i] = Math.max(sell[i -1], buy[i -1] + prices[i]);
        }
        return sell[days -1];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;
//        System.out.println(maxProfit(arr, fee));

        int[] arr1 = new int[]{7, 1, 5, 3, 6, 4};
        int[] arr2 = new int[]{1, 2, 3, 4, 5};
        int[] arr3 = new int[]{7, 6, 4, 3, 1};
        System.out.println(maxProfitMedium(arr3));
    }
}
