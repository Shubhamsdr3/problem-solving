package problemsolving.leetcode75.slidingwindow;

public class MaximumAvgSubArray1 {

    private static double findMaxAverage(int[] nums, int k) {
        long sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        long max = sum;

        for (int i = k; i < nums.length; i++) {
            sum = sum + (nums[i] - nums[i - k]);
            max = Math.max(max, sum);
        }

        return max / 1.0 / k;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        System.out.println(findMaxAverage(nums, k));
    }
}
