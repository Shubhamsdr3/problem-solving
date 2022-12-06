package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    private static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int val = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == val) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0};
    }

    private static int[] twoSumWithMap(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 3, 2, 3};
        System.out.println(Arrays.toString(twoSumWithMap(arr, 6)));
    }
}
