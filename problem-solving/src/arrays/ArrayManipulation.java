package arrays;

import java.util.Arrays;

public class ArrayManipulation {

    /**
     * using Array diff and prefix sum O(n)
     * @param n
     * @param queries
     * @return
     */
    private static long arrayManipulation(int n, int[][] queries) {
        long[] result = new long[n];
        Arrays.fill(result, 0);
        int j = 0;
        while (j < queries.length) {
            int low = queries[j][0];
            int upper = queries[j][1];
            int sum = queries[j][2];
            result[low -1] = result[low-1] + sum;
            if (upper < n) {
                result[upper] = result[upper] - sum;
            }
            j++;
        }

        long max = 0;
        long temp = 0;
        for(int i = 0; i < n; i++){
            temp = temp + result[i];
            if(temp > max) {
                max = temp;
            }
        }
        return max;
    }

    // My version
    private static long arrayManipulation1(int n, int[][] queries) {
        long[] result = new long[n];
        Arrays.fill(result, 0);

        int j = 0;
        long maxVal = Long.MIN_VALUE;
        while (j < queries.length) {
            for (int i = queries[j][0]-1; i < queries[j][1]; i++) {
                result[i] = result[i] + queries[j][2];
                if (result[i] > maxVal) {
                    maxVal = result[i];
                }
            }
            j++;
        }
        return maxVal;
    }

    public static void main(String[] args) {
        int sizeOfTheArray = 5;
        int[][] arr = new int[][] {
                {1, 2, 100},
                {2, 5, 100},
                {3, 4, 100}
        };
        System.out.println(arrayManipulation(sizeOfTheArray, arr));
    }
}
