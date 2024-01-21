package problemsolving.leetcode75;

import java.util.HashSet;
import java.util.Set;

public class MakeArrayZeroBySubtractingEqualAmounts {

    private static int minimumOperations2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) {
            if (num != 0) {
                set.add(num);
            }
        }
        return set.size();
    }



    private static int minimumOperations(int[] nums) {
        int count = 0;
        while (true) {
            int minNum = findMin(nums);
            for (int i = 0; i < nums.length; i++) {
                int result = nums[i] - minNum;
                if (result >= 0) {
                    nums[i] = result;
                }
            }
            if (areAllZero(nums)) break;
            count++;
        }
        return count;
    }

    private static boolean areAllZero(int[] nums) {
        for (int num: nums) {
            if (num != 0) return false;
        }
        return true;
    }

    private static int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num > 0 && num < min) {
                min = num;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 5, 0, 3, 5 };
        System.out.println(minimumOperations2(nums));
    }
}
