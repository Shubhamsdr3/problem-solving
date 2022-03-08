package hard;

import java.util.Stack;

public class LongestValidParentheses {

    private static int longestValidParentheses(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' && s.charAt(i +1) == ')') {
                count = count + 2;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "(()";
        System.out.println(longestValidParentheses(str));
    }
}
