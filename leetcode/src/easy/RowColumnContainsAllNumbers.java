package easy;

import java.util.HashSet;
import java.util.Set;

public class RowColumnContainsAllNumbers {

    private static boolean checkValid(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> column = new HashSet<>();
            for (int j = 0; j < matrix[0].length; j++) {
                if (!row.add(matrix[i][j])) {
                    return false;
                }
                if (!column.add(matrix[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                {1, 2, 3},
                {3, 1, 2},
                {2, 3, 1}
        };
        System.out.println(checkValid(matrix));
        int[][] matrix1 = new int[][] {
                {1, 1, 1},
                {1, 2, 3},
                {1, 2, 3}
        };
        System.out.println(checkValid(matrix1));
        int[][] matrix3 = new int[][] {
                {1, 1, 1},
                {1, 2, 3},
                {1, 2, 5}
        };
        System.out.println(checkValid(matrix3));
    }
}
