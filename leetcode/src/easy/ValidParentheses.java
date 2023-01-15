package easy;

import java.util.Stack;

public class ValidParentheses {

    private static boolean isValid(String s) {
        return false;
    }

    private static boolean isValid1(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "()[]{}";
        String str1 = "{[]}";
        String str2 = "([)]";
        System.out.println(isValid1(str));
        System.out.println(isValid1(str1));
        System.out.println(isValid1(str2));
    }
}
