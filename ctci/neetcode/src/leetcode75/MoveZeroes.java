package leetcode75;

import java.util.Arrays;

public class MoveZeroes {

    private static void moveZeroes(int[] nums) {
        int numberOfZeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                numberOfZeroes++;
            } else if (numberOfZeroes > 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[i - numberOfZeroes] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 0, 1, 0, 3, 12 };
        int[] arr1 = new int[] { 0, 1, 0, 0, 2, 0, 3, 12 };
        moveZeroes(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
