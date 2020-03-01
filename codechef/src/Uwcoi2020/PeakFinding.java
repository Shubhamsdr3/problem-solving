package Uwcoi2020;

import java.util.Scanner;

public class PeakFinding {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int test = scanner.nextInt();
            while (test > 0) {
                int max = Integer.MIN_VALUE;
                int N = scanner.nextInt();
                for (int i =1; i <=N; i++) {
                    int val = scanner.nextInt();
                    if (val > max) {
                        max = val;
                    }
                }
                System.out.println(max);
                test--;
            }
        }
        scanner.close();
    }
}
