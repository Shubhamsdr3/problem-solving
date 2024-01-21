package problemsolving.leetcode75.stack;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

public class DecodeString {

    private static String decodeString(String str) {
        int i = 0;
        Stack<Integer> counter = new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (i < str.length()) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                count = count * 10 + ch - '0';
            } else if (ch == '[') {
                counter.push(count);
                strStack.push(sb);
                sb = new StringBuilder();
                count = 0;
            } else if (ch == ']') {
                StringBuilder temp = sb;
                sb = strStack.pop();
                for (int k = counter.pop(); k > 0; k--) {
                    sb.append(temp);
                }
            } else {
                sb.append(ch);
            }
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "3[a2[c]]";
        String str1 = "3[a]2[bc]";
        String str2 = "100[leetcode]";
        System.out.println(decodeString(str));
        System.out.println(decodeString(str1));
        System.out.println(decodeString(str2));
    }
}
