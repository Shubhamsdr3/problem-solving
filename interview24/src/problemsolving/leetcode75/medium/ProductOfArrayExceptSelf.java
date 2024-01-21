package problemsolving.leetcode75.medium;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    /**
     * T.C -> O(n)
     * Numbers:     2    3    4     5
     * Lefts:       1    2  2*3 2*3*4
     * Rights:  3*4*5  4*5    5     1
     * @param nums
     * @return
     */
    private static int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];
        int n = nums.length;

        // calculate the lefts and store in res.
        int left = 1;
        for (int i = 0; i < n; ++i) {
            if (i > 0) {
                left = left * nums[i - 1];
            }
            res[i] = left;
        }
        System.out.println(Arrays.toString(res));

        // calculate the rights and the product from the end of the array.
        int right = 1;
        for (int i = n - 1; i >= 0; --i) {
            if (i < n - 1) {
                right = right * nums[i + 1];
            }
            res[i] = res[i] * right;
        }
        System.out.println(Arrays.toString(res));
        return res;
    }

    /**
     * T.C -> O(n^2)
     * @param nums
     * @return
     */
    private static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int mult = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i != j) {
                    mult = mult * nums[j];
                }
            }
            res[i] = mult;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 4 };
        int[] nums1 = new int[] { -1, 1, 0, -3, 3 };
        System.out.println(Arrays.toString(productExceptSelf2(nums))); // [24, 12, 8, 6]
    }
}
