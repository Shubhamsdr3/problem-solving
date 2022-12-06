package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestWordInDictionary {

    // TODO:
    private static String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        Map<Character, Integer> count = new HashMap<>();
        for (Character c: s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (String word: dictionary) {
            Map<Character, Integer> map = new HashMap<>();
            for (Character c: word.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (Map.Entry<Character, Integer> entry: map.entrySet()) {
                if (count.containsKey(entry.getKey()) && count.get(entry.getKey()) < entry.getValue()) {
                    break;
                } else {
                    if (word.length() > ans.length()) {
                        ans = word;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str = "abpcplea";
        List<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        System.out.println(findLongestWord(str, list));
    }
}
