package interviewprep_23.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    /**
     * O(n)
     * @param nums
     * @param target
     * @return
     */
    private static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                int prevIdx = map.get(target - nums[i]);
                return new int[]{ prevIdx, i };
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 3, 2, 4 };
        int target = 6;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }
}
