package easy;

public class PowerOfTwo {

    private static boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n-1) == 0;
    }

    public static void main(String[] args) {
        int n = 17;
        System.out.println(isPowerOfTwo(n));
    }
}
