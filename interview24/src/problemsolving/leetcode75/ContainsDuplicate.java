package problemsolving.leetcode75;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {

    private static boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer,Integer> entry: count.entrySet()) {
            if (entry.getValue() >  1) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 2, 3, 1 };
        System.out.println(containsDuplicate(nums));
    }
}
