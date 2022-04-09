package easy;

import java.util.Hashtable;
import java.util.Map;

/**
Created at: 08/03/22
*/

public class WordPattern {


    private static boolean wordPattern(String pattern, String s) {
        String[] arr = s.split(" ");
        if (pattern.length() != arr.length) {
            return false;
        }
        Map<Character, String> map = new Hashtable<>();
        for (int i =0; i < pattern.length(); i++) {
            if (map.get(pattern.charAt(i)) != null &&
                    !map.get(pattern.charAt(i)).equals(arr[i])) {
                return false;
            }
            map.put(pattern.charAt(i), arr[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog dog dog dog";
        System.out.println(wordPattern(pattern, str));
    }
}
