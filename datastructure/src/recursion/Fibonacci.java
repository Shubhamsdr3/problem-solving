package recursion;

public class Fibonacci {

    /**
     * To find a fibonacci series of a number using recursion
     * @param n = 4 -> 0, 1, 1, 2, 3, 5
     * @return
     */
    private static int fib(int n) {
        if (n < 1) {
            throw new IllegalStateException();
        }
        if (n ==1 || n ==2) {
            return n-1;
        }
        return fib(n-1 ) + fib(n-2);
    }

    /**
     * Using Dynamic programming
     * To find the n-th Fibonacci numbers
     * Tabulation method(bottom up approach)
     * @param n
     * @return
     */
    private static int fibDynamic(int n) {
        int[] memo = new int[n+1]; // to store the value of sub-problems
        int i;
        memo[0] = 0;
        if (n > 0) {
            memo[1] = 1;

            for (i=2; i <=n; i++) {
                memo[i]  = memo[i-1] + memo[i-2];
            }
        }

        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(fib(4));
        System.out.println(fibDynamic(9));
    }
}
