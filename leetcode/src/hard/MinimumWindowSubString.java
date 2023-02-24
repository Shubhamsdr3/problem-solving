package hard;

import java.util.HashMap;
import java.util.Map;

/**
 * Created at: 15/01/23
 */
public class MinimumWindowSubString {

    /**
     * 1. Use two pointers: start and end to represent a window.
     * 2. Move end to find a valid window.
     * 3. When a valid window is found, move start to find a smaller window.
     * @param s
     * @param t
     * @return
     */
    private static String minWindowCorrect(String s, String t) {
        int[] map = new int[128];
        for (char ch: t.toCharArray()) {
            map[ch]++;
        }
        int start = 0;
        int end = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int counter = t.length();
        while (end < s.length()) {
            char c1 = s.charAt(end);
            if (map[c1] > 0) counter--;
            map[c1]--;
            end++;
            while (counter ==0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) counter++;
                start++;
            }
        }
        return minLen == Integer.MIN_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    /**
     * Wrong
     * @param s
     * @param t
     * @return
     */
    private static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        if (s.equals(t)) return s;
        int min = Integer.MAX_VALUE;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + t.length(); j <= s.length(); j++) {
                String subString = s.substring(i, j);
                if (contains(subString, t) && subString.length() < min) {
                    min = subString.length();
                    ans = subString;
                }
            }
        }
        return ans;
    }

    private static boolean contains(String str, String subStr) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : subStr.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str.toCharArray()) {
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                map.put(ch, --count);
            }
        }
        for (char ch : str.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "ADOBECODEBANC";
        String t = "ABC";

        String str1 = "aaaaaaaaaaaabbbbbcdd";
        String t1 = "abcdd";
        System.out.println(minWindow(str1, t1)); // "abbbbbcdd"
    }
}
