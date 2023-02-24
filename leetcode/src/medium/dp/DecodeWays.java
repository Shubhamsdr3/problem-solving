package medium.dp;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {

    private static int numDecodings(String s) {
        int numberOfWays = 0;
        Map<Integer, Character> characterMap = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            characterMap.put(i, (char) i);
        }
        int start = 0;
        int end = 1;
        while (start < s.length() && end < s.length()) {
            int value = Integer.parseInt(s.substring(start, end));
            if (characterMap.containsKey(value)) {
                
            }
            if (value <= 26) {

            } else {
                start++;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String str = "226";
        System.out.println(numDecodings(str));
    }
}
