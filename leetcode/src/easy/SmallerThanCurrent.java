package easy;

import java.util.Arrays;

public class SmallerThanCurrent {

    /**
     * Easy one.
     * @param nums
     * @return
     */
    private static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[nums.length];
        int start = 0;
        while (start < nums.length) {
            int count = 0;
            int num = nums[start];
            for (int i = start + 1; i < nums.length; i++) {
                if (nums[i] < num) {
                    count++;
                }
            }
            for (int j = start - 1; j >= 0; j--) {
                if (nums[j] < num) {
                    count++;
                }
            }
            arr[start] = count;
            start++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 1, 2, 2, 3};
        int[] arr1 = new int[]{6, 5, 4, 8};
        int[] arr2 = new int[]{7, 7, 7, 7};
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(arr2)));
    }
}
