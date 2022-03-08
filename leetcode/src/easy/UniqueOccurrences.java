package easy;

import java.util.*;

public class UniqueOccurrences {

    private static boolean uniqueOccurrences(int[] arr) {
        Map<Character, Integer> count = new HashMap<>();
        for (int val : arr) {
            char key = (char) val;
            count.put(key, count.getOrDefault(key, 0) + 1);
        }
        List<Integer> values = new ArrayList<>(count.values());
        return !hasDuplicate(values);
    }

    public static <T> boolean hasDuplicate(Iterable<T> all) {
        Set<T> set = new HashSet<>();
        for (T each: all) {
            if (!set.add(each)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-3,0,1,-3,1,1,1,-3,10,0};
        int[] arr1 = new int[]{1,2};
        System.out.println(uniqueOccurrences(arr1));
    }
}
