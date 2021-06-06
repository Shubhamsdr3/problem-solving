package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class LongestSubStringAtLeastKRepeatingCharacter {

    private static int longestSubstring(String s, int k) {
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> map = new HashMap<>();
            for (int j = i; j < s.length(); j++) {
                if (map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), map.get(s.charAt(j)) +1);
                } else {
                    map.put(s.charAt(j), 1);
                }
            }
            int sum = 0;
            boolean isLessThanK = false;
            for (int value: map.values()) {
                if (value < k) {
                    isLessThanK = true;
                } else {
                    sum = sum + value;
                }
            }
            if (sum > longest) {
                longest = sum;
            }
            if (isLessThanK) {
                break;
            }
        }
        return longest;
    }

    //TODO: complete the solution.
    private static int longestSubString(String s, int k) {
        char[] str = s.toCharArray();
        int[] count = new int[26];
        int h = 0;
        int i = 0;
        int j = 0;
        int idx = 0;
        int max = 0;
        return 0;
    }

    public static void main(String[] args) {
        String str = "ababacb";
        int k = 3;

        String str1 = "aaabb";
        int k1 = 3;
        System.out.println(longestSubstring(str,k));
    }
}
