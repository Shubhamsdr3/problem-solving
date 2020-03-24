package easy;

import java.util.HashSet;
import java.util.Set;

public class ReverseString {

    private static void reverseString(char[] s) {
        int i =0;
        int j = s.length -1;
        while (i < j) {
            char temp = s[j];
            s[j] = s[i];
            s[i] = temp;
            i++;
            j--;
        }
        for (char c: s) {
            System.out.print(c + " ");
        }
    }

    private static String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int i =0;
        int j = arr.length -1;
        while (i < j) {
            if (isVowel(arr[i])) {
                char temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c: arr) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static boolean isVowel(char ch) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        return !set.add(ch);
    }

    public static void main(String[] args) {
//        char[] arr = new char[]{'h','e','l','l','o'};
        String str = "hello";
        System.out.print(reverseVowels(str));
    }
}
