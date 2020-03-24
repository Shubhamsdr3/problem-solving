package easy;

public class SearchInsertPosition {

    private static int searchInsert(int[] nums, int target) {
        int i;
        for (i=0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (nums[i] > target) {
                return i;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,5,6};
        int target = 7;
        System.out.println(searchInsert(arr, target));
    }
}
