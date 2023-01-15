package easy;

public class MatrixDiagonalSum {

    private static int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        for (int i = 0; i < mat.length; i++) {
            sum = sum + mat[i][i]; // (0, 0), (1, 1), (2, 2)...
        }
        for (int i = 0; i < mat.length; i++) {
            sum = sum + mat[i][n - i -1]; //
        }
        sum = sum - ((n % 2  == 0)  ? 0 : mat[n/2][n/2]);
        return sum;
    }

    public static void main(String[] args) {
        int[][] mat = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(diagonalSum(mat));
    }
}
