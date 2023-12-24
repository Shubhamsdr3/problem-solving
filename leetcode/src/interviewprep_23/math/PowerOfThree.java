package interviewprep_23.math;

public class PowerOfThree {

    /**
     * Recursive approach.
     * @param n
     * @return
     */
    private static boolean isPowerOfThree(int n) {
        return n > 0 && (n == 1 || (n % 3 == 0 && isPowerOfThree(n/3)));
    }

    private static boolean isPowerOfThreeIterative(int n) {
        if (n > 1) {
            while (n % 3 == 0) n = n / 3;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        int n = 1;
        System.out.println(isPowerOfThreeIterative(n));
    }
}
