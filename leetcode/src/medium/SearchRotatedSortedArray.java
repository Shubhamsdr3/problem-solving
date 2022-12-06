package medium;

public class SearchRotatedSortedArray {

    private static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (target == nums[mid]) return true;
            if (nums[start] <= nums[mid]) { // left subarray is sorted.
                if (nums[start] <= target && nums[mid] >= target) { // if target lies in start..mid.
                    end = mid -1;
                } else {
                    start = mid + 1;
                }
            } else { // right subarray is sorted.
                if (nums[mid] <= target && target <= nums[end]) {  // if target lies in mid..end.
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[] {
                3, 4, 4, 5, 5, 6, 7, 1, 2
        };
        int target = 8;
        System.out.println(search(input, target));
    }
}
