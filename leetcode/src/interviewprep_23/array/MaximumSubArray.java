package interviewprep_23.array;

public class MaximumSubArray {

    /**
     * Brute force
     * @param nums
     * @return
     */
    private static int maxSubArrayBruteForce(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i, currSum = 0; j < nums.length; j++) {
                currSum = currSum + nums[j];
                ans = Math.max(ans, currSum);
            }
        }
        return ans;
    }

    /**
     * Using DP
     * @param nums
     * @return
     */
    private static int maxSubArrayUsingDp(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {
            dp[i] = nums[i] + (nums[i -1] > 0 ? dp[i - 1]: 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /**
     * Kadane's algorithm
     * @param nums
     * @return
     */
    private static int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(maxEndingHere + nums[i], nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    /**
     * Using divide n Conquer
     * @param nums
     */
    private static int maxSubArrayDivideNConquer(int[] nums) {
        return recurse(nums, 0, nums.length - 1);
    }

    private static int recurse(int[] nums, int left, int right) {
       if (left > right) return Integer.MIN_VALUE;
       int m = left + (right - left) / 2;
       int ml = 0;
       int mr = 0;
       int lMax = recurse(nums, left, m - 1); // left half
       int rMax = recurse(nums, left, m - 1); // right half

       for (int i = m -1, sum = 0; i >= left; i--) {
           sum = sum + nums[i];
           ml = Math.max(sum, ml);
       }

       for (int i = m + 1, sum = 0; i <= right; i++) {
           sum = sum + nums[i];
           mr = Math.max(sum, mr);
       }
       return Math.max(Math.max(lMax, rMax), ml  + mr + nums[m]);
    }


    public static void main(String[] args) {
        int[] nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArrayDivideNConquer(nums));
    }
}
