package easy;

import java.util.*;

public class SortArrayByIncreasingFrequency {

    private static int[] frequencySort(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((m1, m2) -> {
            if (m1.getValue().equals(m2.getValue())) {
                return m2.getKey() - m1.getKey();
            } else {
                return m1.getValue() - m2.getValue();
            }
        });
        maxHeap.addAll(count.entrySet());
        List<Integer> list = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                list.add(entry.getKey());
            }
        }
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {

    }
}
