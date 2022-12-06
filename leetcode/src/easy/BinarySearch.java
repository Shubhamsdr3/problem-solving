package easy;

public class BinarySearch {

    /**
     * Binary search iterative
     * @param nums
     * @param target
     * @return
     */
    private static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1 ;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    /**
     * Binary search recursive
     * @param nums
     * @param target
     * @param start
     * @param end
     * @return
     */

    private static int binarySearch(int[] nums, int target, int start, int end) {
        if (end >= start && end < nums.length) {
            int mid = start + (end - start) /2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                return binarySearch(nums, target, start, mid -1);
            }
            return binarySearch(nums, target, mid + 1, end);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 3, 5, 9, 12};
        int target = 9;
//        System.out.println(binarySearch(arr, target, 0, arr.length));
        System.out.println(search(arr, target));
    }
}
