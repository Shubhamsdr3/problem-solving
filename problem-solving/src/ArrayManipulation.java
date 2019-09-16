import java.util.Arrays;
import java.util.List;

public class ArrayManipulation {

    private static int arrayManipulation(int n, int[][] queries) {
        int[] inputArray = new int[n];

        for (int row = 0; row < queries.length; row++) {
            for (int i = queries[row][0] -1; i < queries[row][1]; i++) {
                inputArray[i] = inputArray[i] + queries[row][2];
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < inputArray.length; i ++ ) {
            if (inputArray[i] > max) {
                max = inputArray[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] queries = new int[][]{{1, 5, 3}, {4, 8, 7}, {6, 9, 1}};
        System.out.println(arrayManipulation(10, queries));
    }

}
