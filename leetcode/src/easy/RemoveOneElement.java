package easy;

public class RemoveOneElement {

    private static boolean canBeIncreasing(int[] nums) {
        int len = nums.length;
        boolean isDeleted = false;
        int preIdx = 0;
        for (int i = 1; i < len; i++) {
            if (nums[preIdx] < nums[i]) {
                preIdx = i;
                continue;
            }
            if (isDeleted) {
                return false;
            }
            isDeleted = true;
            if ((i - 1) > 0) {
                if (nums[i - 2] < nums[i]) {
                    preIdx = i;
                }
            } else {
                preIdx = i;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 1, 2};
        int[] arr1 = new int[]{1, 2, 10, 5, 7};
        System.out.println(canBeIncreasing(arr1));
    }
}
