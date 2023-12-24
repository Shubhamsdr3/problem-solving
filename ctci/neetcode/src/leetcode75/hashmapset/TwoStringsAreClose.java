package leetcode75.hashmapset;

import java.util.*;

public class TwoStringsAreClose {

    private static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] count1 = new int[26];
        int[] count2 = new int[26];

        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        for (char ch: word1.toCharArray()) {
            count1[ch - 'a']++;
            set1.add(ch);
        }

        for (char ch: word2.toCharArray()) {
            count2[ch - 'a']++;
            set2.add(ch);
        }
        System.out.println(set1);
        System.out.println(set2);
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        String word1 = "abbzzca";
        String word2 = "babzzcz";
        System.out.println(closeStrings(word1, word2));
    }
}
