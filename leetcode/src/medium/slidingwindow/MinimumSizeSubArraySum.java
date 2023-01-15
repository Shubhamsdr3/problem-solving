package medium.slidingwindow;

public class MinimumSizeSubArraySum {

    /**
     * T.C -> O(n^2)
     * @param target
     * @param nums
     * @return
     */
    private static int minSubArrayLenBruteForce(int target, int[] nums) {
        int n = nums.length;
        int[] sums = new int[n]; // to store the cumulative sum.
        sums[0] = nums[0];
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i -1] + nums[i]; // get the prefix sum.
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = sums[j] - sums[i] + nums[i];
                if (sum >= target) {
                    ans = Math.min(ans, (j - i + 1));
                    break;
                }
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans: 0;
    }

    /***
     * Sliding window
     * @param target
     * @param nums
     * @return
     */
    private static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            while (sum >= target) { // when sum becomes greater than the target the decrease the values from left.
                min = Math.min(min, i + 1 - left);
                sum = sum - nums[left++];
            }
        }
        return (min != Integer.MAX_VALUE) ? min : 0;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        System.out.println(minSubArrayLenBruteForce(target, arr));
    }
}
