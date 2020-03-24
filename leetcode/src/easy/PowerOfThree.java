package easy;

public class PowerOfThree {

    private static boolean isPowerOfThree(int n) {
        return 1162261467 % n == 0;
    }

    public static void main(String[] args) {
        int n = 27;
        System.out.println(isPowerOfThree(n));
    }
}
