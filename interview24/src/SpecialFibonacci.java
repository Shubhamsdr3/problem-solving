public class SpecialFibonacci {

    /**
     * Write a method/function which provides the nth number in Fibonacci series?
     * Fib(0) = 0, Fib(1)=1, Fib(2)=1, Fib(3)=2, Fib(4)=3, Fib(5)=5, Fib(6)=8 and so on...
     * E.g. Fibonacci series Fib(5) = Fib(4) + Fib(3) = 3 + 2 = 5
     * In mathematics, the Fibonacci numbers, commonly denoted Fn (in above example Fib(n)), form a sequence, called the Fibonacci sequence,
     * such that each number is the sum of the two preceding ones, starting from 0 and 1.
     */

    /**
     * Converting above problem ->
     * Write a method to get the nearest Fibonacci number?
     * E.g.
     * Input: 1 -> Output: 1
     * Input: 6 -> Output:5
     * Input:7 -> Output:8
     * Input: 8 ->
     * For equidistant difference from both greater and lower Fib, get the lower number.
     *
     * @param n
     * @return
     */
    // [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
    private static int fib(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }
        return Math.min(arr[n - 1], arr[n]);
    }

    public static void main(String[] args) {
        System.out.println(fib(6));
    }
}
