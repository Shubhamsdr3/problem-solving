package easy;

public class ClimbingStairs {

    private static final int MIN = 1;
    private static final int MAX = 2;

    private static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            // 1+1, 2
            return 2;
        }

        // with all 1's 1+1+1+1....
        int ways = 1;

        // with one 2
        ways = ways + n-1;

        // with tow 2;s
        if (n % 2 == 0) {
            ways = ways / 2;
        } else {
            int index = 1;
        }
        //FIXME:SHUBHAm
        return 0;
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(climbStairs(n));
    }
}
