package easy;

public class CellsWithOddValuesMatrix {

    private static int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int i=0; i <indices.length; i++) {
            int[] index = indices[i];
            addValue(matrix, index[0], index[1], n, m);
        }
        int count = 0;
        for (int i=0; i < matrix.length; i++) {
            for (int j=0; j < matrix[i].length; j++) {
                if (matrix[i][j] % 2 != 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void addValue(int[][] matrix, int i, int j, int row, int col) {
        for (int r = 0; r < col; r++) {
            matrix[i][r] = matrix[i][r] +1; // col changes here
        }
        for (int c = 0; c < row; c++) {
            matrix[c][j] = matrix[c][j]+1; //TODO: Note here  : row changes here
        }
    }

    /**
     * Optimized one
     * @param n
     * @param m
     * @param indices
     * @return
     */
    public int oddCells1(int n, int m, int[][] indices) {
        boolean[] oddRows = new boolean[n];
        boolean[] oddCols = new boolean[m];

        for (int[] idx : indices) {
            oddRows[idx[0]] ^= true; // if row idx[0] appears odd times, it will correspond to true.
            oddCols[idx[1]] ^= true; // if column idx[1] appears odd times, it will correspond to true.
        }
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < m; ++j) {
                cnt += oddRows[i] ^ oddCols[j] ? 1 : 0; // only cell (i, j) with odd times count of row + column would get odd values.
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int row = 48;
        int col = 37;
        int[][] indices = new int[][] {
                {40, 5}
        };
        System.out.println(oddCells(row, col, indices));
    }
}
