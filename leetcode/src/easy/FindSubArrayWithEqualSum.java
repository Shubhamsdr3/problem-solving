package easy;

import java.util.HashSet;
import java.util.Set;

public class FindSubArrayWithEqualSum {

    /**
     * Using HashSet
     * @param nums
     * @return
     */
    private static boolean findSubArraysUsingHashSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++) {
            if (!set.add(nums[i -1] + nums[i])) {
                return true;
            }
        }
        return false;
    }

    /***
     * Bruteforce. O(n^2)
     * @param nums
     * @return
     */
    private static boolean findSubarrays(int[] nums) {
        if (nums.length <= 2) {
            return false;
        }
        int i = 0;
        int j = i +1;
        while (i < nums.length && j < nums.length) {
            int prevSum = nums[i] + nums[j];
            int start = i +1;
            int end = j + 1;
            while (start < nums.length && end < nums.length) {
                int currentSum = nums[start] + nums[end];
                if (prevSum == currentSum) {
                    return true;
                }
                start++;
                end++;
            }
            i++;
            j++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{77, 95, 90, 98, 8, 100, 88, 96, 6, 40, 86, 56, 98, 96, 40, 52, 30, 33, 97, 72, 54, 15, 33, 77, 78, 8, 21, 47, 99, 48};
//        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(findSubArraysUsingHashSet(arr));
    }
}
