package easy;

import java.util.HashMap;
import java.util.Map;

public class RedistributeCharactersToMakeAllStringsEqual {

    private static boolean makeEqual(String[] words) {
        Map<Character, Integer> count = new HashMap<>();
        for (String word: words) {
            for (Character ch: word.toCharArray()) {
                count.put(ch, count.getOrDefault(ch, 0) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry: count.entrySet()) {
            if (entry.getValue() % words.length != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"a"};
        System.out.println(makeEqual(words));
    }
}
