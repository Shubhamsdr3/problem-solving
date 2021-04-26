package medium;

import java.util.HashSet;
import java.util.Set;

public class MaxErasureValue {

    private static int maximumUniqueSubarray(int[] nums) {
        int l = 0;
        int r = 0;
        int ans = 0;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        while (r < nums.length) {
            if (set.add(nums[r])) {
                sum = sum + nums[r];
                ans = Math.max(ans, sum);
                r++;
            } else {
                sum = sum - nums[l];
                set.remove(nums[l++]);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = new int[] {
                10000, 1, 10000, 1, 1, 1, 1, 1, 1
        };
        int[] input1 = new int[] {
                4,2,4,5,6
        };
        System.out.println(maximumUniqueSubarray(input));
        System.out.println(maximumUniqueSubarray(input1));
    }
}
