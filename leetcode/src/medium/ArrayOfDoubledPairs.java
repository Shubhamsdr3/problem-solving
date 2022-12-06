package medium;

import java.util.Map;
import java.util.TreeMap;

public class ArrayOfDoubledPairs {

    /**
     * arr[2 * i + 1] -> odd
     * arr[2 * i] -> even
     * @param arr
     * @return
     */
    private static boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> count = new TreeMap<>();
        for (int val : arr) {
            count.put(val, count.getOrDefault(val, 0) + 1);
        }
        for (int val : count.keySet()) {
            if (count.get(val) == 0) continue;
            int want = val < 0 ? val / 2 : val * 2;
            if (val < 0 && val % 2 != 0 || count.get(val) > count.getOrDefault(want, 0)) {
                return false;
            }
            count.put(want, count.get(want) - count.get(val));
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, -2, 2, -4};
        System.out.println(canReorderDoubled(arr));
    }
}
