package easy;

public class ValidPalindrome2 {

    private static boolean validPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j)) {
                return isPalindrome(str, i + 1, j) || isPalindrome(str, i, j -1);
            }
            i++;
            j--;
        }
        return true;
    }

    private static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }


    public static void main(String[] args) {
        String str = "aba";
        System.out.println(validPalindrome(str));
    }
}
