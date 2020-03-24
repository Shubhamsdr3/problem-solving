package easy;

public class BuySellStock {

    //O(n2)
    private static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i =0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                int diff = prices[j] - prices[i];
                if (diff > 0 && diff > maxProfit) {
                    maxProfit = diff;
                }
            }
        }

        return maxProfit;
    }

    //O(n) solution
    private static int maxProfit1(int[] prices) {
        int maxProfit = 0;
        for (int i =0; i < prices.length-1; i++) {
            if (prices[i+1] > prices[i] ) {
                maxProfit = maxProfit + prices[i+1]-prices[i];
            }
        }
        return maxProfit;
    }


    public static void main(String[] args) {
        int[] arr =  new int[]{1, 2, 3, 0, 2};
        System.out.println(maxProfit1(arr));
    }
}
