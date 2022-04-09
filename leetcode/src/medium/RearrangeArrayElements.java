package medium;

import java.util.Arrays;

public class RearrangeArrayElements {

    /**
     * Without extra space, wrong
     * @param nums
     * @return
     */
    private static int[] rearrangeArray(int[] nums) {
        int i = 0;
        int j = 1;
        while (i < nums.length && j < nums.length) {
            if (nums[i] < 0) {
                for (int start = i + 1; start < nums.length; start++) {
                    if (nums[start] > 0) {
                        swap(nums, i, start);
                        break;
                    }
                }
            }
            if (nums[j] > 0) {
                for (int start = j + 1; start < nums.length; start++) {
                    if (nums[start] < 0) {
                        swap(nums, j, start);
                        break;
                    }
                }
            }
            i = i + 2;
            j = j + 2;
        }
        return nums;
    }

    private static int[] rearrangeArrayWithExtraSpace(int[] nums) {
        int[] arr = new int[nums.length];
        int positiveIndex = 0;
        int negativeIndex = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                arr[positiveIndex] = nums[i];
                positiveIndex = positiveIndex + 2;
            }
            if (nums[i] < 0) {
                arr[negativeIndex] = nums[i];
                negativeIndex = negativeIndex + 2;
            }
        }
        return arr;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{
                28,-41,22,-8,-37,46,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31
        };
        System.out.println(Arrays.toString(rearrangeArrayWithExtraSpace(arr)));
    }
    // 0 , 1, 2,  3, 4, 5, 6,  7, 8, 9, 10, 11, 12,13,14,15,16,17
    // 28,-41,22,-8,-37,46,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31
    // 28,-41,22,-8, 46,-37,35,-9,18,-6,19,-26,-37,-10,-9,15,14,31 -> 46 -> - 37
    // 28,-41,22,-8, 46,-37,35,-9,18,-6,19,-26,15,-10,-9,-37,14,31 -> - 37 -> 15 // wrong
    // 28,-41,22,-8, 46,-37,35,-9,18,-6,19,-26,15,-10,14,-37, 31,-9
}
