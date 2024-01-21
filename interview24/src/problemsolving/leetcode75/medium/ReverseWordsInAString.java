package problemsolving.leetcode75.medium;

import java.util.Stack;

public class ReverseWordsInAString {

    private static String reverseWords2(String str) {
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        int i = n - 1;

        while (i >= 0) {
            if (str.charAt(i) == ' ') {
                i--;
                continue;
            }
            int j = i - 1;
            while (j >= 0 && str.charAt(j) != ' ') {
                j--;
            }
            sb.append(" ");
            sb.append(str.substring(j + 1, i + 1));
            i = j -1;
        }
        if (sb.length() > 0) sb.deleteCharAt(0);
        return sb.toString();
    }

    /**
     * My solution:
     * Space -> O(n)
     * @param str
     * @return
     */
    private static String reverseWords(String str) {
        Stack<String> stack = new Stack<>();
        String[] splitted = str.split(" "); // O(n)
        for (String s: splitted) { // O(n)
            if (!s.isEmpty()) {
                stack.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {// O(n)
            if (!stack.peek().isEmpty()) {
                sb.append(stack.pop() + " ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String str = "the sky is blue";

        String str1 = "  hello world  ";
        System.out.println(reverseWords2(str1)); // blue is sky the.
    }
}
