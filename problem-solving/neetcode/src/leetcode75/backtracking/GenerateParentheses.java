package leetcode75.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(result, n, 0, "");
        return result;
    }

    private static void helper(List<String> result, int left, int right, String s) {
        if (left == 0 && right == 0) {
            result.add(s);
            return;
        }

        if (left > 0) helper(result, left - 1, right + 1, s + "(");
        if (right > 0) helper(result, left, right - 1, s + ")");
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}
