package medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private static List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", 0, 0, n);
        return list;
    }

    private static void backtrack(List<String> list, String str, int open, int close, int max) {
        if (str.length() == max * 2) { // base case
            list.add(str);
            return;
        }
        System.out.println(str);
        if (open < max) { // open parentheses should be less than the max(3 in this case)
            backtrack(list, str + "(", open+1, close, max);
        }
        if (close < open) { // closed brackets can't be greater than open brackets.
            backtrack(list, str + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
