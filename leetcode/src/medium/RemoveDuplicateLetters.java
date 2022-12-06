package medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
Created at: 25/09/22
*/
public class RemoveDuplicateLetters {

    private static String removeDuplicateLetters(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; i < arr.length -1; ++i) {
            if (arr[i] != arr[i + 1]) {
                sb.append(arr[i]);
            }
        }
        if (i == arr.length -1) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    private static String removeDuplicateLettersCorrect(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        Map<Character, Boolean> visited = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        StringBuilder str = new StringBuilder();
        for (char ch: s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch, 0) - 1);

            if (visited.containsKey(ch) && visited.get(ch)) continue;

            while (!stack.isEmpty() && s.charAt(i) < s.charAt(stack.peek()) && freq.get(s.charAt(stack.peek())) > 0) {
                visited.put(s.charAt(stack.peek()), false);
                stack.pop();
            }
            stack.push(i);
            visited.put(s.charAt(i), true);
        }

        while (!stack.isEmpty()) {
            str.insert(0, s.charAt(stack.peek()));
            stack.pop();
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String str = "cbacdcbc";
        System.out.println(removeDuplicateLettersCorrect(str));
    }
}
