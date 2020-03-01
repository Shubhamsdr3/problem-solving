package easy;

import java.util.Arrays;

public class RemoveDuplicatesFromArray {

    // Algorithm should be in place i.e. it should not use any extra space.
    private static int removeDuplicates(int[] nums) {
        int count =0;
        for (int i=1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }

    private static int removeElement(int[] nums, int val) {
        int count=0;
        for (int i=0; i < nums.length; i++) {
            if (nums[i] == val) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,2,2,3,0,4,2};
        int val = 2;
        int[] arr1 = new int[]{3, 2, 2, 3};
        int val1 = 3;
        System.out.println(removeElement(arr1, val1));

//        int[] arr1 = new int[]{1, 1, 2};
//        System.out.println(removeDuplicates(arr1));
    }
}
