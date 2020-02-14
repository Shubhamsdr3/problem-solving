package easy;

import java.util.Scanner;

public class FizzBuzz {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();
        while (testCases > 0) {
            int n = s.nextInt();
            for (int i=1; i <=n; i++) {
                if (i % 15 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else {
                    System.out.println((i));
                }
            }
            testCases--;
        }
    }
}
