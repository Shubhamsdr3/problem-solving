package implementation;

import java.util.Arrays;

public class ServiceLane {

    private static int[] serviceLane(int n, int[] widths, int[][] cases) {
        int[] result = new int[cases.length];
        for (int i = 0; i < cases.length; i++) {
            result[i] = findMinimum(widths, cases[i][0], cases[i][1]);
        }
        return result;
     }

    private static int findMinimum(int[] arr, int i, int j) {
        int min = Integer.MAX_VALUE;
        for (int s = i; s <= j; s++) {
            if (arr[s] < min) {
                min = arr[s];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int n = 8;
        int[] width = new int[]{2, 3, 1, 2, 3, 2, 3, 3};
        int[][] cases = new int[][]{
                {0, 3},
                {4, 6},
                {6, 7},
                {3, 5},
                {0, 7}
        };

        System.out.println(Arrays.toString(serviceLane(n, width, cases)));
    }
}
