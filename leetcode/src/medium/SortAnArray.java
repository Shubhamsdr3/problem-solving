package medium;

import java.util.Arrays;

public class SortAnArray {

    /**
     * using bubble sort
     * @param nums
     * @return
     */
    private static int[] sortArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i +1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Using merge sort
     * @param nums
     * @return
     */
    private static void sortArrayUsingMergeSort(int[] nums) {
        divide(nums, 0, nums.length - 1);
    }

    private static void divide(int[] arr, int si, int ei) {
        if (si >= ei) { // base case
            return;
        }
        int mid = si + (ei - si) / 2;
        divide(arr, si, mid); // left part
        divide(arr, mid + 1, ei); // right part
        sort(arr, si, mid, ei);
    }

    private static void sort(int[] arr, int si, int mid, int ei) {
        int[] merged = new int[ei - si + 1]; // using auxiliary array
        int left = si; // traverse left array
        int right = mid + 1; // traverse right array
        int index = 0;

        while (left <= mid && right <= ei) {
            if (arr[left] <= arr[right]) {
                merged[index++] = arr[left++];
            } else {
                merged[index++] = arr[right++];
            }
        }

        // if there are only elements left in left array
        while (left <= mid) {
            merged[index++] = arr[left++];
        }

        // if there are only elements left in left array
        while (right <= ei) {
            merged[index++] = arr[right++];
        }

        for (int i = 0, j = si; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    /**
     * Quick sort
     * TC: worst case -> O(n^2)
     *     Avg case -> O(nlogn)
     *
     * Note: Worst case occurs when pivot is always the smallest or largest elemnet i.e. array is alredy sorted.
     * @param arr
     */

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi -1); // for left array i.e. elements smaller than pivot
            quickSort(arr, pi +1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low -1; // no elements smaller than pivot as of now

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) { // we found the smaller element than pivot
                i++;
                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // swap the pivot
        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {
                5, 2, 1, 3
        };
        quickSort(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }
}
