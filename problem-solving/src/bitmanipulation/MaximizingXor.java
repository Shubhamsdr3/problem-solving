package bitmanipulation;

public class MaximizingXor {

    //O(n2)
    private static int maximizingXor(int l, int r) {
        int max = Integer.MIN_VALUE;
        for (int i=l; i <= r; i++) {
            for (int j=l; j <=r; j++) {
                int xor = i ^ j;
                if (xor > max) {
                    max = xor;
                }
            }
        }
        return max;
    }

    // Optimized one.
    private static int maximizingXor1(int l, int r) {
        int xored  = l ^ r;
        int significantBit = 31 - Integer.numberOfLeadingZeros(xored);
        return (1 << (significantBit + 1)) - 1;
    }

    public static void main(String[] args) {
        int l = 10;
        int r = 15;
        System.out.println(maximizingXor1(l, r));
    }
}
