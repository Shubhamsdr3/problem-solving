package hard;

import java.util.Stack;

public class LongestValidParentheses {

    /**
     * TODO
     * @param s
     * @return
     */
    private static int longestValidParentheses(String s) {
        int n = s.length();
        int longest = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    if (s.charAt(stack.peek()) == '(') {
                        stack.pop();
                    } else {
                        stack.push(i);
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            longest = n;
        } else {
            int a = n;
            int b = 0;
            while (!stack.isEmpty()) {
                b = stack.peek();
                stack.pop();
                longest = Math.max(longest, a - b -1);
                a = b;
            }
            longest = Math.max(longest, a);
        }
        return longest;
    }

    public static void main(String[] args) {
        String str = "(";
        String str1 = ")()())";
        System.out.println(longestValidParentheses(str1));
    }
}
