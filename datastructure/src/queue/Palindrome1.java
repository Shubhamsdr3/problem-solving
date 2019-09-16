package queue;


import java.util.LinkedList;

public class Palindrome1 {

    private static boolean isPalindrome(String str) {
        // Using LinkedList for stack and queue.
        LinkedList<Character> stack =  new LinkedList<>();
        LinkedList<Character> queue =  new LinkedList<>();
        String lowerCase = str.toLowerCase();

        for (int i=0; i< lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                stack.push(c);
                queue.addLast(c);
            }
        }

        while (!stack.isEmpty()) {
            if (!queue.removeFirst().equals(stack.pop())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String  string = "abacba";
        System.out.println(isPalindrome(string));
    }
}
