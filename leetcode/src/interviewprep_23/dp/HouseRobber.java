package interviewprep_23.dp;

public class HouseRobber {

    /**
     * with O(1) space
     * @param nums
     * @return
     */
    private static int robUsingDpImproved(int[] nums) {
        if (nums.length == 0) return 0;
        int prev1 = 0;
        int prev2 = 0;
        for (int num: nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = temp;
        }
        return prev1;
    }

    /**
     * T.C -> O(n)
     * S.C -> O(n)
     * @param nums
     * @return
     */
    private static int robUsingDp(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val = nums[i];
            memo[i + 1] = Math.max(memo[i], memo[i-1] + val);
        }
        return memo[nums.length];
    }

    private static int robImproved(int[] nums) {
        return maxRobUtil(nums, nums.length - 1); // starting from end.
    }

    /**
     * rob(i) = Math.max( rob(i - 2) + currentHouseValue, rob(i - 1))
     * @param nums
     * @param i
     * @return
     */
    private static int maxRobUtil(int[] nums, int i) {
        if (i < 0) return 0;
        return Math.max(maxRobUtil(nums, i - 2) + nums[i], maxRobUtil(nums, i - 1));
    }

    /**
     * My approach
     * it has issue as it checks only for interval of 1 not more than that.
     * eg: [2, 1, 1, 2] it will return  -> 3 instead of 4.
     * @param nums
     * @return
     */
    private static int rob(int[] nums) {
        int sum1 = maxRob(nums, 0, 0);
        int sum2 = maxRob(nums, 1, 0);
        return Math.max(sum1, sum2);
    }

    private static int maxRob(int[] nums, int start, int sum) {
        if (start >= nums.length) return sum;
        sum = sum + nums[start];
        return maxRob(nums, start + 2, sum);
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 9, 3, 1 };

        int[] nums1 = new int[] { 2, 1, 1, 2 };
        System.out.println(robUsingDpImproved(nums));
    }
}
