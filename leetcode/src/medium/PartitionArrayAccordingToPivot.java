package medium;

import java.util.Arrays;

public class PartitionArrayAccordingToPivot {

    /**
     * 4 pointers technique.
     * @param nums
     * @param pivot
     * @return
     */
    private static int[] pivotArrayImproved(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 0;
        int right = n -1;
        for (int i = 0, j = n-1; i < n; ++i, --j) {
            if (nums[i] < pivot) {
                ans[left++] = nums[i];
            }
            if (nums[j] > pivot) {
                ans[right--] = nums[j];
            }
        }
        while (left <= right) {
            ans[left++] = pivot;
        }
        return ans;
    }

    /**
     * Naive approach.
     * Space -> O(n)
     * @param nums
     * @param pivot
     * @return
     */
    private static int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int pivotFreq = 0;
        int i = 0;
        // first, enter all the elements less than pivot
        int[] ans = new int[n];
        for (int num : nums) {
            if (num < pivot) {
                ans[i++] = num;
            } else if (num == pivot) {
                ++pivotFreq;
            }
        }
        // second, enter all the pivot elements
        while (pivotFreq-- > 0) {
            ans[i++] = pivot;
        }
        // third, enter all elements greater than pivot.
        for (int num : nums) {
            if (num > pivot) {
                ans[i++] = num;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 9, 12, 5, 10, 14, 3, 10};
        int pivot = 10;
        System.out.println(Arrays.toString(pivotArray(arr, pivot)));
    }
}
