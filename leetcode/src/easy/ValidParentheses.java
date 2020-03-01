package easy;

import java.util.Stack;

public class ValidParentheses {

    private static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i =0; i < s.length(); i++) {

            char current = s.charAt(i);  // s

            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.add(s.charAt(i));
            }
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.peek();
                if (current == '}' && last == '{' || current == ')' && last == '(' || current == ']' && last == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
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
        System.out.println(isValid(str));
        System.out.println(isValid(str1));
        System.out.println(isValid(str2));
    }
}
