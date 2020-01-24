package leetcode;

public class ValidPalindrome {

    private static boolean isValidPalindrome(String string) {
//        String withoutSpace = string.toLowerCase().replaceAll("\\s", "");
//        if (string.length() == 1) {
//            return true;
//        }
//        String validString  = isValidCharacter(withoutSpace);
//        if (validString.length() == 1) {
//            return false;
//        }
        int i=0;
        int j = string.length() -1;
        boolean isValid = true;
        while (i < string.length() && j > 0) {
            if (string.charAt(i) != string.charAt(j)) {
                isValid = false;
                break;
            }
            i++;
            j--;
        }
        return isValid;
    }

    private static String isValidCharacter(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i < string.length(); i++) {
            if ((string.charAt(i) <= 'z' && string.charAt(i) >= 'a')) {
                stringBuilder.append(string.charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String string = "A man, a plan, a canal: Panama";
        String string1 = "race a car";
        String string2 = "a.";
//        System.out.println(isValidPalindrome(string));
//        System.out.println(isValidPalindrome(string1));
        System.out.println(isValidPalindrome(string2));
    }
}
