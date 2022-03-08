package easy;

public class ValidPalindrome2 {

    private static boolean validPalindrome(String s) {
        return isPalindrome(s);
    }

    private static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() -1;
        int count = 0;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                count++;
            }
            i++;
            j--;
        }
        return count <= 1;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(validPalindrome(str));
    }
}
