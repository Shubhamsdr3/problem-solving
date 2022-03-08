package easy;

public class FactorialTrailingZeroes {

    private static int trailingZeroes(int n) {
        int count = 0;
        while (n != 0) {
            int temp = n /5;
            count = count + temp;
            n = temp;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(20));
    }
}
