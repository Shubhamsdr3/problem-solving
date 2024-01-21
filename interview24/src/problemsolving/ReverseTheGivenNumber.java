package problemsolving;

public class ReverseTheGivenNumber {

    private static int reverseNumber(int num) {
        int rev = 0;
        int rem;
        while (num > 0) {
            rem = num % 10;
            rev = (rev * 10) + rem;
            num = num / 10;
        }
        return rev;
    }

    public static void main(String[] args) {
        int n = 45678;
        System.out.println(reverseNumber(n));
    }
}
