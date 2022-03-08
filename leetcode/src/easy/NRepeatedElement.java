package easy;

import java.util.HashMap;
import java.util.Map;

public class NRepeatedElement {

    private static int repeatedNTimes(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length / 2;
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if (entry.getValue() == n) {
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 3};
        int[] nums1 = new int[]{2, 1, 2, 5, 3, 2};
        int[] nums2 = new int[]{5,1,5,2,5,3,5,4};
        int[] nums3 = new int[]{5};
        System.out.println(repeatedNTimes(nums3));
    }
}
