package easy;

public class ValidPalindrome {

    //TODO:ShUBHAM
    private static boolean isValidPalindrome(String string) {
        String withoutSpace = string.toLowerCase().replaceAll("\\s", "");

        System.out.println(withoutSpace);
        return false;
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
        System.out.println(isValidPalindrome(string));
        System.out.println(isValidPalindrome(string1));
        System.out.println(isValidPalindrome(string2));
    }
}
