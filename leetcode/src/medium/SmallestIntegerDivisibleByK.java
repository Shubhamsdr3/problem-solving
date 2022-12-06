package medium;

public class SmallestIntegerDivisibleByK {

    private static int smallestRepunitDivByK(int k) {
        if (k % 2 == 0 || k % 5 == 0) return -1;
        int rem = 0;
        for (int n = 1; n <= k; ++n) {
            rem = (rem * 10 + 1) % k; // 1, 11, 111, 1111, 11111....
            if (rem == 0) return n;
        }
        return -1;
    }

    public static void main(String[] args) {

    }
}
