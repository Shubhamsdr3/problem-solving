package interviewprep_23.array;

public class SearchInRotatedSortedArray {

    /**
     *
     * @param nums
     * @param target
     * @return
     */
    private static int search2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            // left bias.
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            // if left part is monotonically increasing , or the pivot point is on the right part.
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
             }
            // if right part is monotonically increasing , or the pivot point is on the left part.
            else {
//                if (nums[mid] < target && target)
            }
        }
        return 0;
    }

    /**
     * In O(logn) solution.
     * @param nums
     * @param target
     * @return
     */
    private static int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        int rotation = low;
        low = 0;
        high = n -1;
        while (low < high) {
            int mid = (low + high) / 2;
            int realMid = (mid + rotation) % n;
            if (nums[realMid] == target) return realMid;
            if (nums[realMid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        System.out.println(search(nums, target));
    }
}
