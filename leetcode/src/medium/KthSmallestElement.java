package medium;

import java.util.Arrays;

public class KthSmallestElement {

    private static int kthSmallest(int[][] matrix, int k) {
        int[] sortedArray = new int[matrix.length * matrix.length];
        int index = 0;
        for (int i = 0; i < matrix.length; i++) {
            int[] arr = matrix[i];
            for (int j= 0; j < arr.length; j++) {
                sortedArray[index] = arr[j];
                index++;
            }
        }
        Arrays.sort(sortedArray);
        return sortedArray[k-1];
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                {1, 2},
                {1, 3}
        };

        int[][] input1 = new int[][] {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };

        System.out.println(kthSmallest(input1, 8));
    }
}
