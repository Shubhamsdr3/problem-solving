package medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {

    /**
     * Eg: [1, 2, 3]
     * map ->
     *  [1, 1],
     *  [3, 1] -> fist subarray with sum k(3)
     *  [3, 2] -> fist subarray with sum k(3)
     *  count -> 2 subarrays with sum k
     *  T.C => O(n)
     * @param nums
     * @param k
     * @return
     */
    private static int subarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(sum, 1);
        int count = 0;
        for (int num: nums) {
            sum = sum + num;
            if (map.containsKey(sum - k)) {
                count = count + map.get(sum - k);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        return count;
    }

    private static boolean checkIfSubarrayExist(int[] arr, int k) {
        int currentSum = 0;
        int start = 0;
        int end = -1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];
            if (currentSum - k == 0) {
                start = 0;
                end = i;
                break;
            }
            if (map.containsKey(currentSum - k)) {
                start = map.get(currentSum - k) + 1;
                end = i;
                break;
            }
            map.put(currentSum, i);
        }
        if (end == -1) {
            return false;
        }
        return true;
    }

    /**
     * T.C = O(n^2)
     * @param nums
     * @param k
     * @return
     */
    private static int subarraySumBruteForce(int[] nums, int k) {
        int n =  nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3};
        int k = 3;
        System.out.println(subarraySum(arr, k));
    }
}
