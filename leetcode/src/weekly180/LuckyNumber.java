package weekly180;

import java.util.ArrayList;
import java.util.List;

public class LuckyNumber {

    private static List<Integer> luckyNumbers (int[][] matrix) {
        int maxInCol = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();
        for (int i =0; i < matrix.length; i++) {
            int[] arr = matrix[i];
            int minInRow = findMinimum(arr);
            if (minInRow > maxInCol) {
                maxInCol = minInRow;
            }
        }
        return list;
    }

    private static int findMinimum(int[] arr) {
        int min  = Integer.MAX_VALUE;
        for (int item: arr) {
            if (item < min) {
                min = item;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {3,7,8},
                {9,11,13},
                {15,16,17}
        };
        System.out.println(luckyNumbers(arr));
    }
}
