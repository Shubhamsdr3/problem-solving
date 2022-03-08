package easy;

import java.util.Arrays;

public class MaximumProductOfTwoElements {

    private static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length -1;
        return (nums[len] -1) * (nums[len -1] -1);
    }

    public static void main(String[] args) {
         int[] input = new int[]{
                 3, 7
         };
         System.out.println(maxProduct(input));
    }
}
