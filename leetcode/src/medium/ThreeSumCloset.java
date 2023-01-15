package medium;

import java.util.Arrays;

/**
Created at: 04/01/23
*/
public class ThreeSumCloset {


    private static int threeSumClosestImproved(int[] nums, int target) {
        if (nums.length < 2) return 0;
        int closest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int first = 0; first < nums.length -2; ++first) {
            if (first > 0 && nums[first] == nums[first -1]) continue;
            int second = first + 1; // next to first
            int third = nums.length -1; // last one
            while (second < third) {
                int currSum = nums[first] + nums[second] + nums[third];
                if (currSum == target) return currSum; // found the target value
                if (Math.abs(target - currSum) < Math.abs(target - closest)) {
                    closest = currSum; // check the closest one.
                }
                if (currSum > target) {
                    --third; // if current sum is less than target then move third pointer to left
                } else {
                    ++second; // otherwise move second pointer to right.
                }
            }
        }
        return closest;
    }

    /**
     * TLE -> TC: O(n^3)
     * @param nums
     * @param target
     * @return
     */
    private static int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                for (int k = 0; k < nums.length; k++) {
                    if (i != j && j != k && i != k) {
                        int sum = nums[i] + nums[j] + nums[k];
                        int currentDiff = Math.abs(sum - target);
                        if (currentDiff < diff) {
                            diff = currentDiff;
                            res = sum;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ -1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosestImproved(arr, target));

        int[] arr1 = new int[]{0 , 0, 0};
        int target1 = 0;
        System.out.println(threeSumClosestImproved(arr1, target1));
    }
}
