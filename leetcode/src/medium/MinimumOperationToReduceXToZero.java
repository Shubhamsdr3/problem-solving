package medium;

import java.util.HashMap;
import java.util.Map;

public class MinimumOperationToReduceXToZero {

    private static int minOperations(int[] nums, int x) {
        int start = 0;
        int end = nums.length - 1;
        int count = 0;
        while (start < end || x > 0) {
            int num1 = nums[start];
            int num2 = nums[end];
            if (num1 < x && num2 < x) {
                if (num1 > num2) {
                    x = x - num1;
                } else {
                    x = x - num2;
                }
                count++;
                start++;
                end--;
            } else {
                return -1;
            }
        }
        return count;
    }

    private static int minimumOperations(int[] nums, int x) {
        int target = -x;
        for (int num: nums) target = target + num;
        if (target == 0) return nums.length; // all the elements are sums up to x
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - target)) {
                res = Math.max(res, i - map.get(sum - target));
            }
            map.put(sum, i);
        }
        return res == Integer.MIN_VALUE ? -1 : nums.length - res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 4, 2, 3};
        int[] nums1 = new int[]{5, 6, 7, 8, 9};
        int[] nums2 = new int[]{3, 2, 20, 1, 1, 3};
        int x = 10;
        System.out.println(minimumOperations(nums2, x));
    }
}
