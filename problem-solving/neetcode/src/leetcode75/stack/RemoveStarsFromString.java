package leetcode75.stack;

import java.util.Stack;

public class RemoveStarsFromString {

    private static String removeStars(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char ch: str.toCharArray()) {
            if (!stack.isEmpty() && ch == '*') {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        for (char ch: stack) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "leet**cod*e";
        String str1 = "erase*****";
        System.out.println(removeStars(str1));
    }
}
