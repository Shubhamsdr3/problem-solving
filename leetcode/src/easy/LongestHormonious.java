package easy;

import java.util.Map;
import java.util.TreeMap;

public class LongestHormonious {

    private static int findLHS(int[] nums) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i =0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) +1);
        }
        int max = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (map.containsKey(entry.getKey() +1)) {
                if (entry.getValue() + map.get(entry.getKey() +1) > max) {
                    max = entry.getValue() + map.get(entry.getKey() +1);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,3,2,2,5,2,3,7};
        System.out.println(findLHS(arr));
    }
}
