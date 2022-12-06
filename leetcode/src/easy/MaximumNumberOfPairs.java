package easy;

import java.util.Arrays;

public class MaximumNumberOfPairs {

    /**
     * TC: O(n^2)
     * @param nums
     * @return
     */
    private static int[] numberOfPairs(int[] nums) {
        int pairCount = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] >= 0 && nums[j] >= 0 && nums[i] == nums[j]) {
                    pairCount++;
                    nums[i] = -1;
                    nums[j] = -1;
                }
            }
        }
        int len = 0;
        for (int num : nums) {
            if (num != -1) {
                len++;
            }
        }
        return new int[]{pairCount, len};
    }

    private static int[] numberOfPairs1(int[] nums) {
        int[] count = new int[101]; // fixed constraint.
        for (int i: nums){
            count[i]++;
        }
        int pairs = 0;
        int leftOver = 0;
        for (int i: count) {
            pairs = pairs + i/2;
            leftOver = leftOver + i%2;
        }
        return new int[] {pairs, leftOver};
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1,3,2,1,3,2,2 };
        int[] nums1 = new int[] { 1, 1 };
        int[] nums2 = new int[] {0, 0, 1, 1, 2, 2};
        System.out.println(Arrays.toString(numberOfPairs1(nums2)));
    }
}
