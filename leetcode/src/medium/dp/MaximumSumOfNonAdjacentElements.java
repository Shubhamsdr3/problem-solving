package medium.dp;

public class MaximumSumOfNonAdjacentElements {


    private static int maximumNoAdjacentSumUsingTabulation(int[] nums) {
        return 0;
    }

    /**
     * Using Memoization.
     * @param nums
     * @return
     */
    private static int maximumNonAdjacentSum(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        return findMaxSum(n -1, nums, dp);
    }

    private static int findMaxSum(int index, int[] nums, int[] dp) {
        if (index == 0) return nums[index];
        if (index < 0) return 0;
        if (dp[index] != -1) return dp[index];
        int pick = nums[index] + findMaxSum(index - 2, nums, dp);
        int notPick = findMaxSum(index - 1, nums, dp);
        return dp[index] = Math.max(pick, notPick);
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 1, 4, 9 };
        System.out.println(maximumNonAdjacentSum(arr));
    }
}
