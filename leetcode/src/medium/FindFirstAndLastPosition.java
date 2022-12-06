package medium;

import java.util.Arrays;

public class FindFirstAndLastPosition {

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
        System.out.println(Arrays.toString(searchRange(arr, target)));
    }
}
