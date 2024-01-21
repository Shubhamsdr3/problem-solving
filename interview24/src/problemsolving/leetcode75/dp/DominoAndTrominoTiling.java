package problemsolving.leetcode75.dp;

public class DominoAndTrominoTiling {

    /**
     * There shouldn't not be gap when tiling.
     *
     * @param n
     * @return
     */
    private static int numTilings(int n) {
        if (n <= 2) return n;
        int mod = 1_000_000_007;
        long[] fullTiling = new long[n + 1];
        long[] partTiling = new long[n + 1];

        fullTiling[1] = 1;
        fullTiling[2] = 2;

        partTiling[1] = 0;
        partTiling[2] = 1;

        for (int i = 3; i <= n; i++) {
            fullTiling[i] = (fullTiling[i -1] + fullTiling[i - 2] + 2 * partTiling[i - 1] % mod);
            partTiling[i] = (partTiling[i - 1] + fullTiling[i - 2] % mod);
        }
        return (int) (fullTiling[n]);
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(numTilings(n));
    }
}
