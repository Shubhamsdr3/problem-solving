package interviewprep_23.array;

import java.util.Arrays;

public class SortColors {

    /**
     * RED -> 0
     * WHITE -> 1
     * BLUE -> 2
     * @param nums
     */
    private static void sortColors(int[] nums) {
        int left = 0;
        int end = nums.length -1;
        int mid = 0;
        while (mid <= end) {
            if (nums[mid] == 0) {
                swap(nums, left++, mid++); // if starting is 0 then
            } else if (nums[mid] == 2) {
                swap(nums, mid, end--);
            } else {
                mid++;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2,0,2,1,1,0 };
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
