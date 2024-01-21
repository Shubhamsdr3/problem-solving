package problemsolving.leetcode75.dp;

public class HouseRobber {

    /**
     * Using DP.
     * Iterative + Memo (bottom-up)
     * @param nums
     * @return
     */
    private static int robDp(int[] nums) {
        if (nums.length == 0) return 0;
        int[] memo = new int[nums.length + 1];
        memo[0] = 0;
        memo[1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int val  = nums[i];
            memo[i + 1] = Math.max(memo[i], memo[i - 1] + val);
        }
        return memo[nums.length];
    }

    /**
     * Using recursion.
     * @param nums
     * @return
     */
    private static int rob(int[] nums) {
        return maxRob(nums, nums.length - 1);
    }

    private static int maxRob(int[] nums, int i) {
        if (i < 0) return 0;
        return Math.max(maxRob(nums, i - 2) + nums[i], maxRob(nums, i - 1));
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 1, 2 };
        System.out.println(robDp(arr));
    }
}
