package medium;

import java.util.Arrays;

public class SetZero {

    private static void setZeroes(int[][] matrix) {
        int[][] copied = copy2DArray(matrix);
        for (int i = 0; i < copied.length; i++) {
            int[] row = copied[i];
            for (int j = 0; j < row.length; j++) {
                if (row[j] == 0) {
                    setZero(matrix, i, j);
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void setZero(int[][] matrix, int row, int col) {
        Arrays.fill(matrix[row], 0);
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    private static int[][] copy2DArray(int[][] arr) {
        int[][] copy = new int[arr.length][arr[0].length];
        for (int i =0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                copy[i][j] = arr[i][j];
            }
        }
        return copy;
    }


    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
        setZeroes(arr);
    }
}
