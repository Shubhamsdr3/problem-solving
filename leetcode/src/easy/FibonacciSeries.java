package easy;

public class FibonacciSeries {

    private static int fib(int n) {
        if (n ==0 || n ==1) {
            return n;
        }
        return fib(n-1 ) + fib(n-2);
    }

    public static void main(String[] args) {
        System.out.println(fib(7));
    }
}