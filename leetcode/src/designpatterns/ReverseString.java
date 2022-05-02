package designpatterns;

/**
 * Reverse a string without affecting special characters?
 * Primary Example ->
 * Input:   str = "a,b$c"
 * Output:  str = "c,b$a"
 * Non-special characters: a-zA-Z0-9
 * Secondary Example ->
 * Input:   str = "A4b,c,d0e!$"
 * Output:  str = "e0d,c,b4A!$"
 */
public class ReverseString {

    private static String reverseString(String str) {
        char[] charArray = str.toCharArray();
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (!isAlphaNumeric(charArray[i] + "")) {
                i++;
            } else if (!isAlphaNumeric(charArray[j] + "")) {
                j--;
            } else {
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;
                i++;
                j--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : charArray) {
            sb.append(ch);
        }
        return sb.toString();
    }

    private static boolean isAlphaNumeric(String s) {
        String pattern = "^[a-zA-Z0-9]*$";
        return s.matches(pattern);
    }

    public static void main(String[] args) {
        System.out.println(reverseString("A4b,c,d0e!$"));
    }
}
