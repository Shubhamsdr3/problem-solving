package easy;

import java.util.HashSet;
import java.util.Set;

public class LargestSubStringBetweenTwoEqualCharacters {

    private static int maxLengthBetweenEqualCharacters(String s) {
        int maxLen = -1;
        Set<Character> set = new HashSet<>();
        int slow = 0;
        int fast = 0;
        while (slow < s.length() && fast < s.length()) {
            if (!set.add(s.charAt(fast))) {
                maxLen = Math.max(maxLen, s.substring(slow + 1, fast).length());
            }
            if (fast == s.length() - 1) {
                slow++;
                fast = slow + 1;
            } else {
                fast++;
            }
        }
        return maxLen;
    }


    private static int maxLengthBetweenEqualCharactersImproved(String s) {
        int maxLen = -1;
        int[] indices = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            if (indices[idx] > 0) { // the character is already present.
                maxLen = Math.max(maxLen, i - indices[idx]);
            } else {
                indices[idx] = i + 1;
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str = "mgntdygtxrvxjnwksqhxuxtrv";
        String str2 = "abca";
        String str3 = "scayofdzca";
//        System.out.println(maxLengthBetweenEqualCharacters(str));
        System.out.println(maxLengthBetweenEqualCharactersImproved(str2));
//        System.out.println(maxLengthBetweenEqualCharacters(str3));
    }
}
