package easy;

import java.util.HashMap;
import java.util.Map;

public class NumberOfUnequalTripletsInArray {


    /**
     * @param nums
     * @return
     */
    private static int unequalTripletsImproved(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x: nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        // Total combination
        int ans = n * (n - 1) * (n -2) / 6;
        for (int count: map.values()) {
            if (count < 2) {
                continue;
            }
            int same3Cnt = count * (count -1) * (count -2) / 6;
            int same2Cnt = (n - count) * count * (count -1) / 6;
            ans = ans - same3Cnt + same2Cnt;
        }
        return ans;
    }

    /**
     * TC -> O(n^3)
     * @param nums
     * @return
     */
    private static int unequalTriplets(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 4, 4, 2, 4, 3 };
        int[] nums1 = new int[] { 1, 1, 1, 1, 1 };
        System.out.println(unequalTripletsImproved(nums));
    }
}
