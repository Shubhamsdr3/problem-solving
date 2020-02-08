package easy;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {

    private static int singleNumber(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i< nums.length; i++) {
            int val = count.get(nums[i]) == null ? 0 : count.get(nums[i]);
            count.put(nums[i], ++val);
        }
        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }

    //using bit manipulation
    // a^b^a == a
    private static int singleNumber1(int[] arr) {
        int result = 0;
        int n = arr.length;
        for (int i = 0; i<n; i++) {
            result = result ^ arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, -1, -2};
        int[] arr1 = new int[]{2, 2, 1, 4, 1};
        System.out.println(singleNumber1(arr1));
    }
}
