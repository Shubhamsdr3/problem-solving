package easy;

import java.util.*;

public class TopKFrequentElement {

    private static List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) +1);
        }
        List<Map.Entry<Integer, Integer>> listOfEntries = new ArrayList<>(count.entrySet());
        // sorting HashMap by values using comparator
        listOfEntries.sort(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry: count.entrySet()) {
            if (k > 0) {
                list.add(entry.getKey());
            } else {
                break;
            }
            k--;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 1, -1, 2, -1, 2, 3};
        int k = 2;
        System.out.print(topKFrequent(arr, k));
    }
}
