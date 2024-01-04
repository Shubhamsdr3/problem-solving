package interviewprep_23.array;

public class SearchInRotatedArray {

    private static int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length -1;
        while (start <= end) {
            int mid = (start + end) /2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[start]) {
                if (target <= nums[mid] && target >= nums[start]) {
                    end  = mid - 1;
                } else  {
                    start = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[end])  {
                    start = mid + 1;
                } else  {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(arr, target));
    }
}