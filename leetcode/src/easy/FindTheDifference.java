package easy;

import java.util.HashMap;
import java.util.Map;

public class FindTheDifference {

    private static char findTheDifference(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i=0; i < s.length(); i++) {
            int occurrence = count.get(s.charAt(i)) == null ? 0 : count.get(s.charAt(i));
            count.put(s.charAt(i), ++occurrence);
        }

        for (int j=0; j < t.length(); j++) {
            if (count.get(t.charAt(j)) == null) {
                return t.charAt(j);
            }
        }
        return 'b';
    }

    private static char findTheDifference1(String s, String t) {
        int charCodeS = 0;
        int charCodeT = 0;
        for (int i = 0; i < s.length(); ++i) {
            charCodeS += s.charAt(i);
        }
        for (int i = 0; i < t.length(); ++i) {
            charCodeT += t.charAt(i);
        }
        return (char)(charCodeT - charCodeS);
    }

    public static void main(String[] args) {
        String str = "abcd";
        String string = "abced";
        String str1 = "ae";
        String string1 = "aea";
        System.out.println(findTheDifference1(str1, string1));
        System.out.println(findTheDifference1(str, string));
    }
}
