package mxplayer;

import java.util.Stack;

public class SearchingChallenge {

    private static String searchingChallenge(String str) {
        char[] arr = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c: arr) {
            if (c == '(' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == ']') {
                try {
                    stack.pop();
                } catch (Exception ex) {
                    return "0";
                }
                count++;
            }
        }
        return "1 " + count;
    }

    public static void main(String[] args) {
        String str1 = "(Hello[world])(!)";
        String str = "(coder)[byte)]";
        String str2 = "(c([od]er))b[yt[e])";
        System.out.println(searchingChallenge(str2));
    }
}
