package medium;

import java.util.Arrays;

public class FindFirstAndLastPosition {


    /**
     * Improved.
     * @param nums
     * @param target
     * @return
     */
    private static int[] searchRangeImproved(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        int[] ans = new int[]{ -1, -1 };
        // check for the starting position.
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] < target) start = mid + 1;
            else end = mid;
        }
        if (nums[start] != target) return ans;
        else ans[0] = start;
        // check for the end position.
        end = nums.length -1;
        while (start < end) {
            int mid = (start + end) / 2 + 1;
            if (nums[mid] > target) end = mid -1;
            else start = mid;
        }
        ans[1] = end;
        return ans;
    }

    /**
     * TLE
     * @param nums
     * @param target
     * @return
     */
    private static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int left = 0;
        int right = nums.length;
        int[] range = new int[]{-1, -1};
        while (left < right) {
            int mid = (left + (right - left)) / 2;
            if (nums[mid] == target) { // target found at the mid element.
                int leftIndex = mid;
                while (leftIndex > 0 && nums[leftIndex - 1] == target) { // search in the left sub-array
                    leftIndex--;
                }
                range[0] = leftIndex;
                int rightIndex = mid;
                while (rightIndex < right -1 && nums[rightIndex + 1] == target) { // search in right sub-array
                    rightIndex++;
                }
                range[1] = rightIndex;
                return range;
            } else if (target < nums[mid]) {
                right = mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            }
        }
        return range;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 7, 7, 8, 8 , 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRangeImproved(arr, target)));
    }
}
