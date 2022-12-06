package medium;

import java.util.*;

public class FindOriginalArrayFromDoubledArray {

    /**
     * Time complexity: O(NlogK)
     * @param changed
     * @return
     */
    private static int[] findOriginalArray1(int[] changed) {
        int n = changed.length;
        int i = 0;
        if (n % 2 == 1) return new int[0];
        int[] res = new int[n / 2];
        Map<Integer, Integer> count = new TreeMap<>();
        for (int val : changed) {
            count.put(val, count.getOrDefault(val, 0) + 1); // frequency of every element.
        }
        for (int x: count.keySet()) {
            if (count.get(x) > count.getOrDefault(x + x, 0)) {
                return new int[0];  // count(x) < count(2 * x) -> not possible.
            }
            for (int j = 0; j < count.get(x); ++j) {
                res[i++] = x; // this element has 2x element.
                count.put(x + x, count.get(x + x) - 1); // remove the complementary element of x (i.e 2 * x)
            }
        }
        return res;
    }

    private static int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < changed.length; i++) {
            int mul = changed[i] * 2;
            binarySearch(mul, i, changed.length -1, changed, list);
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        if (list.size() * 2 == changed.length) {
            return arr;
        }
        return new int[]{};
    }

    private static void binarySearch(int mul, int start, int end, int[] changed, List<Integer> list) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            if (changed[mid] >= 0 && changed[mid] == mul) {
                list.add(changed[mid]);
                changed[mid] = -1;
                return;
            } else if (changed[mid] > mul) {
                binarySearch(mul, start, mid -1, changed, list);
            } else if (changed[mid] < mul) {
                binarySearch(mul, mid + 1, end, changed, list);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,4,2,6,8};
        int[] arr1 = new int[]{6, 3, 0, 1};
        int[] arr2 = new int[]{1};
        int[] arr3 = new int[]{0, 0, 0, 0};
        System.out.println(Arrays.toString(findOriginalArray1(arr)));
//        System.out.println(Arrays.toString(findOriginalArray1(arr3)));
    }
}
