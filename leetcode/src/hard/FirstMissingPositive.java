package hard;


import java.util.Arrays;

/**
Created at: 08/01/23
*/
public class FirstMissingPositive {

    private static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
                System.out.println(Arrays.toString(nums));
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 4, -1, 1 };
        int[] arr1 = new int[] { 7, 8, 9, 11, 12 };
        System.out.println(firstMissingPositive(arr1));
    }
}

