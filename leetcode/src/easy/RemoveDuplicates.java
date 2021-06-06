package easy;

import java.util.Arrays;

public class RemoveDuplicates {

    private static int removeDuplicates(int[] nums) {
        int i = nums.length > 0 ? 1: 0;
        for (int num: nums) {
            if (num > nums[i-1]) {
                nums[i++] = num;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] input = new int[]{
                0,0,1,1,1,2,2,3,3,4
        };
        System.out.println(removeDuplicates(input));
    }
}
