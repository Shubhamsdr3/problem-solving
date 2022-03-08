package easy;

import java.util.Arrays;

public class FindSubsequenceOfLength {

    private static int[] maxSubsequence(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        while (i < nums.length) {
            int sum = nums[i];
            int start = i +1;
            while (start < i + k) {
                sum = sum + nums[start];
                start++;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, -2, 3, 4};
        int k = 3;
        System.out.println(Arrays.toString(maxSubsequence(arr, k)));
    }
}
