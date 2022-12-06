package easy;

import java.util.HashMap;
import java.util.Map;

/**
Created at: 20/11/22
*/
public class CheckTwoStringEquivalent {

    private static boolean checkAlmostEquivalent(String word1, String word2) {
        if(word1.equals(word2)) return true;
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < word1.length(); i++) {
            count.put(word1.charAt(i), count.getOrDefault(word1.charAt(i), 0) + 1);
        }
        for (int j = 0; j < word2.length(); j++) {
            count.put(word1.charAt(j), count.getOrDefault(word1.charAt(j), 0) - 1);
        }

        for (Map.Entry<Character, Integer> map: count.entrySet()) {
            if (Math.abs(map.getValue()) > 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String word1 = "zzzyyy";
        String word2 = "iiiiii";
        System.out.println(checkAlmostEquivalent(word1, word2));
    }
}
