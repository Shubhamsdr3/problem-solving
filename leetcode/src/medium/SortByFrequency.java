package medium;

import java.util.*;

public class SortByFrequency {

    private static String frequencySort(String s) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i=0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) +1);
        }
        List<Map.Entry<Character, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry: list) {
            int count = entry.getValue();
            char ch = entry.getKey();
            while (count > 0) {
                sb.append(ch);
                count--;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str1 = "cccaaa";
        String str2 = "Aabb";
        System.out.print(frequencySort(str2));
    }
}
