package easy;

import java.util.Arrays;

public class SortArrayByParity2 {

    /**
     * Extra Space: O(n)
     * @param nums
     * @return
     */
    private static int[] sortArrayByParityII(int[] nums) {
        int[] arr = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                arr[index] = nums[i];
                nums[i] = -1;
                index = index + 2;
            }
        }
        index = 1;
        for (int i = 0; index < nums.length && i < nums.length; i++) {
            if (nums[i] != -1) {
                arr[index] = nums[i];
                index = index + 2;
            }
        }
        return arr;
    }

    /**
     * Without extra space
     * @param nums
     * @return
     */
    private static int[] sortArrayByParityIIWithoutExtraSpace(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        while (i < n && j < n) {
            while (i < n && nums[i] % 2 ==0) {
                i = i + 2;
            }
            while (j < n && nums[j] % 2 == 1) {
                j = j + 2;
            }
            if (i < n && j < n) {
                swap(nums, i, j);
            }
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        int[] input = new int[] {
                5, 8, 7, 6, 3, 2
        };
        System.out.println(Arrays.toString(sortArrayByParityIIWithoutExtraSpace(input)));
    }
}
