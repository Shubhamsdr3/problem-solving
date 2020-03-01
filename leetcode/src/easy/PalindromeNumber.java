package easy;

public class PalindromeNumber {

    private static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        return x == reverseInt(x);
    }

    private static int reverseInt(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + x % 10;
            x = x /10;
        }
        return rev;
    }

    public static void main(String[] args) {
        int num = 121;
        System.out.println(isPalindrome(num));
    }
}
