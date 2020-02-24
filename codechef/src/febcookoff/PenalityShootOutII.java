package febcookoff;

import java.util.Scanner;

public class PenalityShootOutII {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int test = sc.nextInt();
            while (test > 0) {
                int countA = 0;
                int countB = 0;

                int shots = sc.nextInt() * 2;

                while (shots > 0) {

                    int a = sc.nextInt();
                    if (a == 1) {
                        countA++;
                    }
                    int b = sc.nextInt();
                    if (b == 1) {
                        countB++;
                    }
                    shots--;
                }
                if (countA - countB > 2) {
                    System.out.println(countA);
                } else if (countB - countA > 2) {
                    System.out.println(countB);
                }

                test--;
            }
        }
    }

}
