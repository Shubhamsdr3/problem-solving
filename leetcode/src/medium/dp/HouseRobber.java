package medium.dp;

public class HouseRobber {

    private static int robUsingDp(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return dp[nums.length];
    }

    private static int rob(int[] nums) {
        return recursion(nums, nums.length - 1);
    }

    private static int recursion(int[] nums, int index) {
        if (index < 0) return 0;
        return Math.max((recursion(nums, index - 2) + nums[index]), recursion(nums, index - 1));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 9, 3, 1};
        int[] arr1 = new int[]{1, 2, 3, 1};
        System.out.println(robUsingDp(arr));
        System.out.println(robUsingDp(arr1));
    }
}
