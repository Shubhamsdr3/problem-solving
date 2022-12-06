package medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumDeletionsToMakeStringBalanced {

    private static int minimumDeletions(String s) {
        int count = 0;
        return helper(s, count, 0,   1);
    }

    private static int helper(String sb, int count,  int start, int end) {
        if (start >= sb.length() && end >= sb.length()) {
            return count;
        }
        if (sb.charAt(start) > sb.charAt(end)) {
            sb = sb.replaceFirst(sb.charAt(start) + "", "");
            count++;
            start = 0;
            end = 1;
        }
        return helper(sb, count, ++start, ++end);
    }

    /**
     * Using stack.
     * @param str
     * @return
     */
    private static int minimumDeletions1(String str) {
        int count = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c: str.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == 'b' && c == 'a') {
                stack.pop();
                count++;
            } else {
                stack.push(c);
            }
        }
        return count;
    }

    private static int minimumDeletionUsingDp(String str) {
        int l = str.length();
        int[] dp = new int[l + 1];
        int bCount = 0;
        for (int i = 0; i < l; i++) {
            if (str.charAt(i) == 'a') {
                dp[i + 1] = Math.min(dp[i] + 1, bCount);
            } else {
                dp[i + 1] = dp[i];
                bCount++;
            }
        }
        return dp[l];
    }

    public static void main(String[] args) {
        String str = "aababbab";
        System.out.println(minimumDeletionUsingDp(str));
    }
}
