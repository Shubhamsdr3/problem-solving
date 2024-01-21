package problemsolving.leetcode75.prefixSum;

public class FindPivotIndex {

    private static int pivotIndex(int[] nums) {
        int totalSum = 0;
        int leftSum = 0;
        for (int item: nums) {
            totalSum = totalSum + item;
        }

        for (int i = 0; i < nums.length; leftSum = leftSum + nums[i++]) {
            if (leftSum * 2 == totalSum - nums[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 7, 3, 6, 5, 6 };
        int[] arr1 = new int[] { 1, 2, 3};
        int[] arr2 = new int[] {2, 1, -1};
        System.out.println(pivotIndex(arr1));
        System.out.println(pivotIndex(arr2));
    }
}
