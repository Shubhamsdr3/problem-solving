package medium;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubArraySum {


    /**
     * T.C -> O(n^2)
     * @param nums
     * @param k
     * @return
     */
    private static boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * T.C = O(n)
     * S.C -> O(k)
     * @param nums
     * @param k
     * @return
     */
    private static boolean checkSubarraySumImproved(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int runningSum = 0;
        for (int i = 0; i < nums.length; i++) {
            runningSum = runningSum + nums[i];
            if (k != 0) runningSum = runningSum % k;
            Integer prev = map.get(runningSum);
            if (prev != null && i - prev > 1) return true;
            else map.put(runningSum, i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 23, 2, 6, 4, 7 };
        int k = 6;
        System.out.println(checkSubarraySumImproved(arr, k));
    }
}
