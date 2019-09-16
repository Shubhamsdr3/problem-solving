package stack;

import java.util.LinkedList;

public class Palindrome {

    private static boolean isPalindrome(String str) {
        LinkedList<Character> linkedList =  new LinkedList<>();
        StringBuilder stringNoPunctuation = new StringBuilder(str.length());

        for (int i = 0; i < str.length(); i ++) {
            char c = str.toLowerCase().charAt(i);
            if (c >= 'a' && c <= 'z' ) {
                stringNoPunctuation.append(c);
                linkedList.push(c);
            }
        }
        StringBuilder reverseString = new StringBuilder(str.length());
        while (!linkedList.isEmpty()) {
            reverseString.append(linkedList.pop());
        }

        return reverseString.toString().equals(stringNoPunctuation.toString());

    }

    public static void main(String[] args) {
        String  string = "I did, did I?";
        System.out.println(isPalindrome(string));
    }
}
