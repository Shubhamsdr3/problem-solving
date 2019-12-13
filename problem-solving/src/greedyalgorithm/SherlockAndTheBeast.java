package greedyalgorithm;

//Try this again ???
public class SherlockAndTheBeast {

    /**
     * Decent numbers can be if:
     * 1. Its digits can only be 3's and/or 5's.
     * 2. The number of 3's it contains is divisible by 5.
     * 3. The number of 5's it contains is divisible by 3.
     * 4. It is the largest such number for its length.
     *@param n : The number of digits decent number can have.
     */
    private static void decentNumber(int n) {
        if (n == 1) {
            System.out.println(-1);
            return;
        }
        if (n % 3 == 0) {
            for (int i = 0; i < n; i++) {
                System.out.print(5);
            }
            System.out.println();
            return;
        }

        if (n % 5 == 0) {
            for (int i = 0; i< n; i++) {
                System.out.print(3);
            }
        }
        for (int i=1; i<=n; i++) {
            for (int l = 1; l <=n; l++) {
                if (i * 3 + 5 *l == n) {
                    int m = i*3;
                    for (int j=0; j < m; j++ ) {
                        System.out.print(5);
                    }
                    for (int k = 0; k < n - m; k++) {
                        System.out.print(3);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        decentNumber(3);
        decentNumber(6);
        decentNumber(9);
        decentNumber(12);
        decentNumber(15);
    }
}
