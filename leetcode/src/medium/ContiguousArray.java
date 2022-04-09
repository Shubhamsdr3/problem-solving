package medium;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class ContiguousArray {

    /**
     * TC = O(n^2)
     */
    private static int findMaxLength(int[] nums) {
        int zeroes = 0;
        int ones = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) {
                    zeroes++;
                } else {
                    ones++;
                }
                if (zeroes == ones) {
                    count = Math.max(count, j - i + 1);
                }
            }
        }
        return count;
    }

    /**
     * TC: O(n)
     * @param nums
     * @return
     */
    private static int findMaxLengthUsingMap(int[] nums) {
        if (nums == null && nums.length == 0) { // base case
            return 0;
        }
        // converting all 0 to -1
        for (int  i =0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        int sum = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i]; // cumulative sum
            if (map.containsKey(sum)) {
                int last = map.get(sum);
                max = Math.max(max, i - last);
            } else {
                map.put(sum, i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 0, 0, 1, 0, 1};
        System.out.println(findMaxLengthUsingMap(arr));
    }
}
