package leetcode75.hashmapset;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueNumberOfOccurrences {

    private static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num: arr) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for (Map.Entry<Integer, Integer> map: count.entrySet()) {
            if (!set.add(map.getValue())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 2, 1, 1, 3 };
        int[] arr1 = new int[] { 1, 2};
        System.out.println(uniqueOccurrences(arr1));
    }
}
