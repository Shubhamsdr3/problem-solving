package marchchallenge2020;

import java.util.Scanner;

public class XOREngine {

    private static void findNumberOf1s(int q, int[] seq) {
        int numberOfEven1 = 0;
        int numberOfOdd1 = 0;
        for (int i=0; i < seq.length; i++) {
            if (countSetBits(seq[i] ^ q) % 2 == 0) {
                numberOfEven1++;
            } else {
                numberOfOdd1++;
            }
        }
        System.out.print(numberOfEven1 + " " + numberOfOdd1);
    }

    private static int countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
//        int q = 3;
//        int[] arr = new int[]{4, 2, 15, 9, 8, 8};
//        findNumberOf1s(q, arr);

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int test = sc.nextInt();
            while (test > 0) {
                int n = sc.nextInt();
                int q = sc.nextInt();
                int[] arr = new int[n];
                for (int i=0; i < n; i++) {
                    arr[i] = sc.nextInt();
                }
                while (q > 0) {
                    int val = sc.nextInt();
                    findNumberOf1s(val, arr);
                    q--;
                }
                test--;
            }
        }

    }
}
