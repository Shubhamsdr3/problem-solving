package easy;

import java.util.HashSet;

public class LongestPallindrome {

    //TODO:FixmE
    private static int longestPalindrome(String s) {
        if (areAllCharacterEqual(s)) {
            return s.length();
        }
        int[] count = new int[26];
        for (int i=0; i< s.length(); i++) {
            if (s.charAt(i) <= 'z' && s.charAt(i) >= 'a') {
                count[s.charAt(i) - 'a']++;
            } else {
                count[s.charAt(i) - 'A']++;
            }
        }
        int len = 0;
        for (int i=0; i <count.length; i++) {
            if (count[i] > 0 && count[i] % 2 == 0) {
                len = len + count[i];
            }
        }
        return ++len;
    }

    private static boolean areAllCharacterEqual(String str) {
        boolean isEqual = true;
        for (int i =0; i <str.length()-1; i++) {
            if (str.charAt(i) != str.charAt(i+1)) {
                isEqual = false;
            }
        }
        return isEqual;
    }

    public static void main(String[] args) {
        String string = "bananas";
        System.out.println(longestPalindrome(string));
    }
}
