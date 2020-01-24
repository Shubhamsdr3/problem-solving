package strings;

import java.util.LinkedHashSet;
import java.util.Set;

public class TwoCharacter2 {

    private static int alternate(String s) {
        String uniqueString = removeDuplicates(s);
        for (int i=0; i < uniqueString.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder(s);
            for (int j=0; j < stringBuilder.length(); j++) {
                if (uniqueString.charAt(i) == stringBuilder.charAt(j)) {
                    stringBuilder.deleteCharAt(j);
                }
            }
            if (isValidString(stringBuilder.toString())) {
                return stringBuilder.length();
            }
        }
        return 0;
    }

    private static boolean isValidString(String string) {
        boolean isValid = false;
        for (int i=0; i < string.length() -1; i++) {
            // if alternate characters are same.
            if (string.charAt(i) == string.charAt(i + 1)) {
                // If two adjacent characters are same.
                return false;
            } else isValid = i < string.length() - 2 && string.charAt(i) == string.charAt(i + 2);
        }
        return isValid;
    }

    private static String removeDuplicates(String string) {
        char[] arr = string.toCharArray();
        Set<Character> characters = new LinkedHashSet<>();
        for (char c: arr) {
            characters.add(c);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character c: characters) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String string = "abaacdabd";
        System.out.println(alternate(string));
    }
}
