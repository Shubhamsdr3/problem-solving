package problemsolving.leetcode75.heap;

import java.util.*;

public class TopKFrequentElements {

    private static int[] topKFrequent(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        Queue<Integer> pq = new PriorityQueue<>();
        for (int key: map.keySet()) {
            pq.offer(key);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            ans.add(pq.poll());
        }

        int[] result = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 1, 1, 2, 3, 3 };
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(arr, k)));
    }
}
