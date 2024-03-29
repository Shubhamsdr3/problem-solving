package easy;

import java.util.Arrays;

public class TransposeMatrix {

    private static int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                result[col][row] = matrix[row][col];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(Arrays.deepToString(transpose(matrix)));
    }
}
