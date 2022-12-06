package medium;

import java.util.Arrays;

public class WiggleSort2 {

    /**
     *
     */
    private static void wiggleSortImproved(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1)/2);
        int n = nums.length;
        int left = 0;
        int right = 0;
        int i = 0;
        while (i <= right) {
            if (nums[newIndex(i, n)] > n) {
                swap(nums, newIndex(left++, n), newIndex(i++, n));
            } else if (nums[newIndex(i, n)] < median) {
                swap(nums, newIndex(right--, n), newIndex(i, n));
            } else {
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    private static int newIndex(int idx, int n) {
        return (1 + 2 * idx) % (n | 1);
    }


    /**
     * Calculating the median
     * Sorting: O(nlogn) + O(n) traversing
     * @param nums
     */
    private static void wiggleSort(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        int n = nums.length;
        int left = (n + 1)/2 - 1; // median index
        System.out.println(left);
        int right = n -1;  // largest value index
        for (int i = 0; i < n; i++) { // copy large value on odd indexes
            if (i % 2 == 1) {
                nums[i] = copy[right];
                right--;
            } else { // copy values decrementing from median to even indexes.
                nums[i] = copy[left];
                left--;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 13, 6, 5, 5, 4, 2 };
        wiggleSortImproved(arr);
    }
}
