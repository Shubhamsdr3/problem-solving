package easy;

import java.util.HashMap;
import java.util.Map;

public class BalancedString {

    private static int balancedStringSplit(String s) {
        int i = 0;
        int j = i+1;
        int count = 0;
        while (i < s.length() && j < s.length()-1) {
            if (s.charAt(i) != s.charAt(j) || s.charAt(j) != s.charAt(j+1)) {
                if (hasEqualCharacters(s.substring(i, j+1))) {
                    count++;
                    i = j+1;
                    j = i;
                }
            }
            j++;
        }
        if (j == s.length()-1) {
            if (hasEqualCharacters(s.substring(i, j+1))) {
                count++;
            }
        }
        return count;
    }

    /**
     * solution
     * @param s
     * @return
     */
    private static int balancedStringSplit1(String s) {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'L') {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0){ // means number of 'L' == 'R'
                ++res;
            }
        }
        return res;
    }

    private static boolean hasEqualCharacters(String subString) {
        Map<Character, Integer> count = new HashMap<>();
        for (char c : subString.toCharArray()) {
            if (count.containsKey(c)) {
                int count1 = count.get(c);
                count.put(c, ++count1);
            } else {
                count.put(c, 1);
            }
        }
        for (int i = 0; i < subString.length()-1; i++) {
            if (!count.get(subString.charAt(i)).equals(count.get(subString.charAt(i + 1)))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "RLRRLLRLRL";
        String str1 = "RLLLLRRRLR";
        String str2 = "LLLLRRRR";
        System.out.println(balancedStringSplit1(str));
        System.out.println(balancedStringSplit1(str1));
        System.out.println(balancedStringSplit1(str2));
    }
}
