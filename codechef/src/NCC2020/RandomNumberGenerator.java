package NCC2020;

import java.util.Scanner;

public class RandomNumberGenerator {

    private static void randomNumberGenerator(int n , int s) {
        for (int i=1; i <= 5*n; i++) {
            if (findNumberOfDigits(i) == n && findSumOfDigits(i) == s ) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("1");
    }

    private static int findNumberOfDigits(int num) {
        int count = 0;
        while(num != 0) {
            num /= 10;
            ++count;
        }
        return count;
    }

    private static int findSumOfDigits(int num) {
        String string = String.valueOf(num);
        int sum = 0;
        for (int i=0; i < string.length(); i++) {
            sum = sum + Character.getNumericValue(string.charAt(i));
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int test = sc.nextInt();
            while (test > 0) {
                int n = sc.nextInt();
                int s = sc.nextInt();
                randomNumberGenerator(n, s);
                test--;
            }
        }
    }
}
