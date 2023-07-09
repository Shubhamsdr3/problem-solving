package interviewprep_23.array;

import java.util.Arrays;

public class SetColors {

    /**
     * using two pointers technique.
     * @param nums
     */
    private static void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length;
        for (int i = 0; i < right; i++) {
            if (nums[i] == 0) {
                swap(nums, left++, i);
            }
            if (nums[i] == 2) {
                swap(nums, --right, i--);
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
