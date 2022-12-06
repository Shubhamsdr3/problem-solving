package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReshapeTheMatrix {

    private static int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) {
            return mat;
        }
        List<Integer> list = new ArrayList<>();
        for (int[] arr : mat) {
            for (int j = 0; j < mat[0].length; j++) {
                list.add(arr[j]);
            }
        }
        int currentIndex = 0;
        int[][]  result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = list.get(currentIndex);
                currentIndex++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {1, 2},
                {3, 4}
        };
        int r = 2;
        int c = 4;
        System.out.println(Arrays.deepToString(matrixReshape(arr, r, c)));
    }
}
