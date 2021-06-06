package medium;

import java.util.Arrays;

public class RotateImage {

    private static void rotate(int[][] matrix) {
        int s = 0;
        int e = matrix.length -1;
        while (s < e) {
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++;
            e--;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i+1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotate(arr);
    }
}
