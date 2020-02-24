package hackerearth.febcircuits20;

import java.util.Scanner;

public class EqualTo100 {

    private static void find100thSum(int num) {
        while (num > 0) {
            num--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0) {
            int num = sc.nextInt();
            find100thSum(num);
            test--;
        }
    }
}
