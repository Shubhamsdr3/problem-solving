package interviewprep_23.array;

import java.util.Arrays;

public class RotateArray {

    /**
     * Using rotation.
     * @param nums
     * @param k
     */
    private static void rotateImproved(int[] nums, int k) {
       k = k % nums.length;
       reverse(nums, 0, nums.length - 1);
       reverse(nums, 0, k - 1);
       reverse(nums,  k, nums.length - 1);
       System.out.println(Arrays.toString(nums));
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * O(n)
     * extra space.
     * @param nums
     * @param k
     */
    private static void rotateWithExtraSpace(int[] nums, int k) {
        int[] arr = new int[nums.length];
        int start = nums.length - k;
        int index = 0;
        for (int i = start; i < nums.length; i++) {
            arr[index] = nums[i];
            index++;
        }
        for (int i = 0; i < start; i++) {
            arr[index] = nums[i];
            index++;
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * TLE: O(kn)
     * No extra space.
     * @param nums
     * @param k
     */
    private static void rotate(int[] nums, int k) {
        while(k > 0) {
            int temp = nums[nums.length - 1];
            int i = nums.length -1;
            for (; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[i] = temp;
            k--;
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 1,2, 3, 4, 5, 6, 7 };
        int[] arr1 = new int[]{ -1, -100, 3, 99 };
        int k = 3;
//        rotate(arr, k);
//        rotateWithExtraSpace(arr, k);
        rotateImproved(arr, k);
    }
}
