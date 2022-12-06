package medium;

public class MaximumProfit {

    private static int maxProfit(int[] cost) {
        int profit = 0;
        for (int i = 0; i < cost.length -1; i++) {
            if (cost[i] < cost[i + 1]) {
                profit = profit + (cost[i + 1] - cost[i]);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6, 5, 3, 7, 1, 4};
        System.out.println(maxProfit(arr));
    }
}
