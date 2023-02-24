package interviewprep.kadenesalgorithm;

public class BestTimeToBuySellStock3 {

    /**
     * @param prices
     * @return
     */
    private static int maxProfitMedium(int[] prices) {
        int i = 1;
        int maxProfit = 0;
        int lastProfit = 0;
        int transaction = 0;
        while(i < prices.length) {
            if (prices[i] > prices[i -1]) {
                int currentProfit = maxProfit + prices[i] - prices[i -1];
                if (transaction >= 2 && currentProfit > lastProfit) {
                    maxProfit = maxProfit - lastProfit;
                    maxProfit = maxProfit + currentProfit;
                    lastProfit = currentProfit;
                } else {
                  maxProfit = maxProfit + currentProfit;
                }
                transaction++;
            }
            i++;
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println(maxProfitMedium(arr));
    }
}
