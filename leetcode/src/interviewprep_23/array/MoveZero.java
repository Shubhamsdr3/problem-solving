package interviewprep_23.array;

import java.util.Arrays;

public class MoveZero {

    private static void moveZeroes(int[] nums) {
        int n = nums.length;
        int start = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[start] = num;
                start++;
            }
        }
        while (start < n) {
            nums[start++] = 0;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 0, 3, 12 };
        moveZeroes(arr);
    }
}
