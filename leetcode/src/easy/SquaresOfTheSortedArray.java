package easy;

import java.util.Arrays;

public class SquaresOfTheSortedArray {

    /**
     * In O(n) time
     * @param nums
     * @return
     */
    private static int[] sortedSquareUsingTwoPointer(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(nums[start]) > Math.abs(nums[end])) { // start is greater
                result[i] = nums[start] * nums[start];
                start++;
            } else { // if end is greater
                result[i] = nums[end] * nums[end];
                end--;
            }
        }
        return result;
    }

    /**
     * Almost O(n) time.
     * @param nums
     * @return
     */
    private static int[] sortedSquares(int[] nums) {
       int[] arr = new int[nums.length];
       arr[0] = nums[0] * nums[0];
       for (int i = 1; i < nums.length; i++) {
           int num = nums[i] * nums[i];
           arr[i] = num;
           int currIdx = i;
           int prev = currIdx - 1;
           while (prev >= 0 && currIdx > 0 && arr[prev] > arr[currIdx]) {
               swap(arr, prev, currIdx);
               currIdx--;
               prev--;
           }
       }
       return arr;
    }

    private static void swap(int[] arr, int prev, int currIdx) {
        int temp = arr[currIdx];
        arr[currIdx] = arr[prev];
        arr[prev] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { -4, -1, 0, 3, 10 };

        int[] arr1 = new int[] { -7, -3, 2, 3, 11 };
        System.out.println(Arrays.toString(sortedSquareUsingTwoPointer(arr1)));
    }
}
