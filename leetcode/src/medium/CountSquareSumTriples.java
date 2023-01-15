package medium;

import java.util.HashSet;
import java.util.Set;

public class CountSquareSumTriples {

    /**
     *
     * @param n
     * @return
     */
    private static int countTriplesUsingHashSet(int n) {
        int count = 0;
        Set<Integer> squares = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            squares.add(i * i);
        }
        for (int a : squares) {
            for (int b: squares) {
                if (squares.contains(a + b)) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * O(n^3)
     * Square triplets = a^2 + b^2 = c^2
     * find Square triplets -> 1 <= a, b, c <= n.
     * @param n
     * @return
     */
    private static int countTriples(int n) {
        int count = 0;
        for (int i =1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (i != j && i != k && j != k) {
                      if ((i * i) + (j * j) == (k * k)) {
                          count++;
                      }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.println(countTriplesUsingHashSet(n));
    }
}
