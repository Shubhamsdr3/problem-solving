package interviewprep_23.dp;

public class MaximumSubArray {

    private static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            maxSum = Math.max(sum, maxSum);
            if (sum < 0) sum = 0;
        }
        return maxSum;
    }

    private static int maxSubArrayUsingDp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + (Math.max(dp[i - 1], 0));
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(arr));
        System.out.println(maxSubArrayUsingDp(arr));
    }
}
