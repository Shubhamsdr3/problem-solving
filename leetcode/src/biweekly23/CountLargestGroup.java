package biweekly23;

public class CountLargestGroup {

    private static int countLargestGroup(int n) {
        return 0;
    }

    private static int getDigitSum(int n) {
        int sum = 0;
        while (n != 0) {
            sum = sum + n % 10;
            n = n/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(countLargestGroup(n));
    }
}
