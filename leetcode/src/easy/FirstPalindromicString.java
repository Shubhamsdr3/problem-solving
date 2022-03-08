package easy;

public class FirstPalindromicString {

    private static String firstPalindrome(String[] words) {
        for (String str: words) {
            if (isPalindrome(str)) {
                return str;
            }
        }
        return "";
    }

    private static boolean isPalindrome(String str) {
        int i =0;
        int j = str.length()-1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] arr = new String[] {"notapalindrome","racecar"};
        System.out.println(firstPalindrome(arr));
    }
}
