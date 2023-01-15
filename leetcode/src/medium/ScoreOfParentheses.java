package medium;

import java.util.Stack;

public class ScoreOfParentheses {

    private static int scoreOfParentheses(String s) {
        int score = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(score);
                score = 0;
            } else {
                score = stack.pop() + Math.max(2 * score, 1);
            }
        }
        return score;
    }

    public static void main(String[] args) {
//        String str = "(())";
//        String str = "()";
        String str = "(()(()))";
        System.out.println(scoreOfParentheses(str));
    }
}
