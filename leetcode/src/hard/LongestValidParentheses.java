package hard;

import java.util.Stack;

/**
Created at: 14/01/23
*/
public class LongestValidParentheses {


    private static int longestValidParenthesesUsingStack(String str) {
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
     }

    /**
     * @param str
     * @return
     */
    private static int longestValidParenthesesUsingDp(String str) {
        int maxLen = 0;
        int[] dp = new int[str.length()];
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if (str.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i -2]: 0) + 2;
                } else if ((i - dp[i -1]) > 0 && str.charAt(i - dp[i -1]- 1) == '(') {
                    dp[i] = dp[i -1] + (i - dp[i -1] >= 2 ? dp[i - dp[i -1]]: 0) + 2;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    /**
     * TLE
     * T.C -> O(n^3)
     * S. C -> O(n)
     * @param s
     * @return
     */
    private static int longestValidParentheses(String s) {
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String subString = s.substring(i, j + 1);
                if (isValid(subString)) {
                    maxLen = Math.max(maxLen, subString.length());
                }
            }
        }
        return maxLen;
    }

    private static boolean isValid(String subString) {
       Stack<Character> stack = new Stack<>();
       for (char ch: subString.toCharArray()) {
           if (!stack.isEmpty() && ch == ')' && stack.peek() == '(') {
               stack.pop();
           } else {
               stack.push(ch);
           }
       }
       return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "(()";
        String str1 = ")(()()))";
//        System.out.println(longestValidParenthesesUsingDp(str));
        System.out.println(longestValidParenthesesUsingStack(str1));

        String str2 = "";
//        System.out.println(longestValidParenthesesUsingDp(str2));
    }
}
