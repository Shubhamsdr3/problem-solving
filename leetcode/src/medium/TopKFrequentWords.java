package medium;

import java.util.*;

public class TopKFrequentWords {

    private static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (o1, o2) -> o1.getValue().equals(o2.getValue()) ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue()
        );
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            list.add(0, pq.poll().getKey());
        }
        return list;
    }

    public static void main(String[] args) {
        String[] words = new String[]{
                "the","day","is","sunny","the","the","the","sunny","is","is"
        };
        int k = 4;
        System.out.println(topKFrequent(words, k));
    }
}

