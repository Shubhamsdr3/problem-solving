package easy;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FirstUniqueCharacter {

    private static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),  map.getOrDefault(s.charAt(i), 0) +1);
        }

        for (int i =0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String str = "loveleetcode";
        String str1 = "leetcode";
        System.out.print(firstUniqChar(str1));
    }
}
