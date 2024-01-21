package problemsolving.leetcode75.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    private static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        // calculate the lefts.
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                left = left * nums[i - 1];
            }
            res[i] = left;
        }

        // calculate the rights
        int right = 1;
        for (int i = n -1; i >= 0; i--) {
            res[i] = res[i] * right;
            right = right * nums[i];
        }
        return res;
    }

    /**
     * TLE
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
        int[] arr = new int[] { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(productExceptSelf2(arr)));
    }
}
