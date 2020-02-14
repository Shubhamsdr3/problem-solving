package strings;

import java.util.Arrays;

public class TwoCharacter {

    private static int alternate(String s) {
        String unique = findUniqueCharacter(s);

        int i = 0;
        int j = i+1;

        while (i < unique.length()-1) {
            removeDuplicate(s, unique.charAt(i));
            removeDuplicate(s, unique.charAt(j));
            if (isValidString(s)) {
                return s.length();
            }
            i++;
            j++;
        }


//        for (int i=0; i < unique.length(); i++) {
//            for (int j = i+1; j < unique.length(); j++) {
//                string = removeDuplicate(string, unique.charAt(i));
//                string = removeDuplicate(string, unique.charAt(j));
//                if (isValidString(string)) {
//                    return string.length();
//                }
//            }
//        }
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

    private static String removeDuplicate(String str, char a) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != a) {
                stringBuilder.append(str.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    private static String findUniqueCharacter(String string) {
      StringBuilder stringBuilder = new StringBuilder();
      char[] chars = string.toCharArray();
      Arrays.sort(chars);
      stringBuilder.append(chars[0]);
      for (int i=1; i < chars.length; i++) {
          if (chars[i -1] != chars[i]) {
              stringBuilder.append(chars[i]);
          }
      }
      return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String string = "beabeefeab";
        System.out.println(alternate(string));
    }
}
