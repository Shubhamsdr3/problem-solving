package medium;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {

    /**
     * T.C -> O(n)
     * S.C -> O(n) for stack
     * @param s
     * @return
     */
    private static int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        return stack.size();
    }

    /**
     * T.C -> O(n)
     * S.C -> O(1) for stack
     * @param s
     * @return
     */
    private static int minAddToMakeValidOptimized(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { // need to add ')'
                right++;
            } else if (right > 0) { // need to '('
                right--;
            } else {
                left++;
            }
        }
        return left + right;
    }

    public static void main(String[] args) {
        String input = "()";
        System.out.println(minAddToMakeValidOptimized(input));
    }
}
