package interviewprep_23.array;

import java.util.Arrays;

public class RotateImage {

    private static void rotate(int[][] matrix) {
        int last = matrix.length -1;
       for (int i = 0; i < last; i++) {
           swap(matrix[i][i], matrix[i][last]);
           swap(matrix[i][i], matrix[last][last]);
           swap(matrix[i][i], matrix[last][i]);
       }
       System.out.println(Arrays.deepToString(matrix));
    }

    private static void swap(int i , int j) {
        int temp = i;
        i = j;
        j = temp;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] { { 1, 2, 3}, { 4, 5, 6}, { 7, 8, 9 }};
        rotate(input);
//        System.out.println(Arrays.deepToString(input));
    }
}
