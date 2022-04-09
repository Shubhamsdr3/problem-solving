package easy;

import java.util.Arrays;

public class SortEvenOddIndependently {

    /**
     * * Even -> non-decreasing order
     * Odd -> non-increasing order
     * @param nums
     * @return
     */
    private static int[] sortEvenOdd(int[] nums) {
        int evenIndex = 0;
        int oddIndex = 1;
        int  n = nums.length;
        while (evenIndex < n && oddIndex < nums.length) {
            if (evenIndex + 2 < n && nums[evenIndex] > nums[evenIndex + 2]) {
                swap(nums, evenIndex, evenIndex+ 2);
            }
            if (oddIndex + 2 < n && nums[oddIndex] < nums[oddIndex + 2]) {
                swap(nums, oddIndex, oddIndex + 2);
            }
            evenIndex = evenIndex + 2;
            oddIndex = oddIndex + 2;
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {
               4, 4, 3, 2, 1, 6
        };
        System.out.println(Arrays.toString(sortEvenOdd(arr)));
    }

    // [36,45,32,31,15,41,9,46,36,6,15,16,33,26,27,31,44,34]


}
