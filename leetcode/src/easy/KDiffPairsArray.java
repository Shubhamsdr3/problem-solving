package easy;

import java.util.HashMap;
import java.util.Map;

public class KDiffPairsArray {

    private static int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0)  {
            return 0;
        }

        int count = 0;
        HashMap<Integer, Integer> map =  new HashMap<>();

        for (int i =0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    // count the number of pairs.
                    count++;
                }
            } else if (map.containsKey(entry.getKey() + k)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 4, 1, 5};
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{1, 3, 1, 5, 4};
        int[] arr3 = new int[]{1, 1, 1, 2, 1};
        System.out.println(findPairs(arr, 2));
//        System.out.println(findPairs(arr1, 1));
//        System.out.println(findPairs(arr2, 0));
//        System.out.println(findPairs(arr3, 1));
    }
}
