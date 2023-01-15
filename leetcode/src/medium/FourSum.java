package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
Created at: 09/12/22
*/
public class FourSum {

    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int defaultValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    for (int l = 0; l < nums.length; l++) {
                        if (i != j && j != k && k != l && l != i) {
                            if (nums[i] != defaultValue && nums[j] != defaultValue && nums[k] != defaultValue && nums[l] != defaultValue) {
                                int sum = nums[i] + nums[j] + nums[k] + nums[l];
                                if (sum == target) {
                                    result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                                    nums[i] = defaultValue;
                                    nums[j] = defaultValue;
                                    nums[k] = defaultValue;
                                    nums[l] = defaultValue;
                                }
                            }
                        }
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 0, -1, -0, -2, 2 };
        int k = 0;
        System.out.println(fourSum(nums, k));
    }
}
