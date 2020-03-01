package easy;

public class PowerOfTwo {

    private static boolean isPowerOfTwo(int n) {
        if (n == 1 || n == 2) {
            return true;
        }
        while (n > 0) {
            if (n % 2 == 0){
                n = n % 2;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 17;
        System.out.println(isPowerOfTwo(n));
    }
}
