package medium;

public class SubArrayProductLessThanK {

    private static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k == 0) return 0;
        int count = 0;
        int pro = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            pro = pro * nums[j];
            while (i <= j && pro >= k) {
                pro = pro / nums[i++];
            }
            count = count + j - i + 1;
        }
        return count;
    }

    /**
     * Using sliding window.
     * @param nums
     * @param k
     * @return
     */
    private static int numSubarrayProductLessThanKUsingSlidingWindow(int[] nums, int k) {
        if (k <= 1) return 0;
        int left = 0;
        int right = 0;
        int prod = 1;
        int ans = 0;
        while (right < nums.length) {
            prod = prod * nums[right];
            while (prod >= k) {
                prod = prod / nums[left];
                left++;
            }
            ans = ans + (right - left + 1);
            right++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{10, 5, 2, 6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanKUsingSlidingWindow(nums, k));
    }
}
