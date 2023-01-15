package interview_22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SetMatrixZeroes {

    static class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static void setZeroes(int[][] matrix) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    pairs.add(new Pair(i, j));
                }
            }
        }
        setMatrixZero(matrix, pairs);
    }

    private static void setMatrixZero(int[][] matrix, List<Pair> position) {
        for (Pair pair: position) {
            int row1 = 0;
            int col1 = 0;
            // set row to zero
            while (col1 < matrix[pair.row].length) {
                matrix[pair.row][col1] = 0;
                col1++;
            }
            // set column to zero
            while (row1 < matrix.length) {
                matrix[row1][pair.col] = 0;
                row1++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
