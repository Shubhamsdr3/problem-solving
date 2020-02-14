package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MatrixRotation {

    /**
     * printing matrix in spiral form
     * @param row:
     * @param col:
     * @param matrix:
     */
    private static void printMatrixInSpiral(int row, int col, int[][] matrix) {
        int i;
        int k = 0;
        int l = 0;
        int lastRow = row -1;
        int lastCol = col - 1;

        while (k < lastRow && l < lastCol) {
            // print the top row
            for (i = l; i <= lastCol; i++) {
                System.out.print(matrix[k][i] + " ");
            }
            k++;

            // print the last col
            for (i = k; i <= lastRow; i++) {
                System.out.print(matrix[i][lastRow] + " ");
            }
            lastCol--;

            //print the bottom
            if (k <= lastRow) {
                for (i = lastCol; i >= l; i--) {
                    System.out.print(matrix[lastRow][i] + " ");
                }
                lastRow--;
            }

            //print fist column
            if (l <= lastCol) {
                for (i = lastRow; i >= k; i--) {
                    System.out.print(matrix[i][l] + " ");
                }
                l++;
            }
        }
    }

    public static void main(String[] args) {
        int rotation = 2;
        int row = 4;
        int col = 4;
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(Arrays.asList(1, 2, 3, 4));
        matrix.add(Arrays.asList(5, 6, 7, 8));
        matrix.add(Arrays.asList(9, 10, 11, 12));
        matrix.add(Arrays.asList(13, 14, 15, 16));

        int[][] matrix1 = new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        printMatrixInSpiral(row, col, matrix1);
    }
}
