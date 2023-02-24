package medium.dp;

public class LongestIncreasingSubsequence {

    /**
     * Using recursion and DP.
     * 1. Express everything in index: eg f(prevIdx, index)
     * 2. Explore all.
     * 3. Take the maximum length.
     * 4. Base case.
     * @param nums
     * @return
     */
    private static int lengthOfLis(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        return findMaxLis(nums, -1, 0, dp);
    }

    private static int findMaxLis(int[] nums, int prev, int currentIdx, int[][] dp) {
        if (currentIdx == nums.length) return 0;
        if (dp[currentIdx][prev + 1] != -1) return dp[currentIdx][prev];
        int len = 0 + findMaxLis(nums, prev, currentIdx + 1, dp); // not taking. 0 -> no increasing length.
        if(prev == -1 || nums[currentIdx] > nums[prev]) {
            len = Math.max(len, 1 + findMaxLis(nums, currentIdx, currentIdx + 1, dp)); // taking.
        }
        return dp[currentIdx][prev + 1] = len;
    }

    /**
     * Brute force.
     * TC => O(n^2)
     * @param nums
     * @return
     */
    private static int lengthOfLIS(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int count = 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j]  > num) {
                    count++;
                    num = nums[j];
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 10,9,2,5,3,7,101,18 };
        int[] arr1 = new int[]{ 0, 1, 0, 3, 2, 3 };
        System.out.println(lengthOfLis(arr1));
    }
}
