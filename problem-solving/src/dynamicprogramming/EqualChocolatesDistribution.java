package dynamicprogramming;

import java.util.Arrays;

public class EqualChocolatesDistribution {

    /**
     * Only 1, 2, 5 chocolates can be added.
     * @param arr: To equalize elements
     * @return : the number of operations performed.
     *
     * For some delta = (d0 d1 ... dn-1) where d0 = element - (min - i)
     * di = ai * 5 + bi * 2 + ci * 1
     * ai = di / 5
     * bi = (di % 5) / 2
     * ci = (((di % 5) % 2) / 1)
     */
    private static int equal(int[] arr) {
        int numberOfOperations;
        for (int i=0; i< arr.length; i++) {

        }
        return 0;
    }

    static int equal1(int[] a) {
        int min = Arrays.stream(a).min().orElse(-1);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 5; ++i) {
            int ops = 0;
            for (int j = 0; j < a.length; ++j) {
                int t = a[j] - (min - i); // min -1, min -2, min -3, min -4
                ops  = ops + t/5 + t % 5/2 + t % 5 % 2; // or t % 5 % 2/1  as above formula.
            }
            ans = Math.min(ans, ops);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] inputArray = new int[]{2, 2, 3, 7};
        System.out.println(equal1(inputArray));
    }
}
