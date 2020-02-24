package biweekly20;

import java.util.*;

public class NumberOfSubstring {

    private static int numberOfSubstrings(String s) {
        String subString = "abc";
        int count = 0;
        for (int i=0; i < s.length(); i++) {
            for (int j = i + subString.length(); j < s.length(); j++) {
                if (getUniqueCharacter(s.substring(i, j)).equals(subString)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static String getUniqueCharacter(String substring) {
        SortedSet<Character> set = new TreeSet<>();
        for (char c: substring.toCharArray()) {
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        for (Character character : set) {
            sb.append(character);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String string = "abcabc";
        System.out.println(numberOfSubstrings(string));
    }
}
