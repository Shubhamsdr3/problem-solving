package medium;

public class UniqueBinarySearchTrees {

    /**
     * Catalan number:
     */
    private int catalan(int n) {
        int res = 0;

        if (n <= 1) {
            return 1;
        }
        for (int i = 0; i < n; i++) {
            res = res + catalan(i) * catalan(n - i - 1);
        }
        return res;
    }

    //FIXME :SHUBHAM
    private static int numTrees(int n) {
        return 0;
    }

    public static void main(String[] args) {

    }
}
