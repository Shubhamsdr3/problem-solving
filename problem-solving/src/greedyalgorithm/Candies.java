package greedyalgorithm;

import java.util.Arrays;

public class Candies {

    // Complete the candies function below.
    private static long candies(int n, int[] arr) {
//        Arrays.sort(arr);
        int[] result = new int[n];
        Arrays.fill(result, 1);
        for (int i=1; i < arr.length; i++) {
            if (arr[i] > arr[i-1]) {
                result[i] = result[i-1] + result[i];
            }
        }
        for (int i = arr.length-2; i >= 0; i--) {
            if (arr[i] > arr[i +1] && result[i] <= result[i+1]) {
                result[i] = result[i+1] + 1;
            }
        }

        long sum = 0;

        for (int val: result) {
            sum += val;
        }

        return sum;
    }

    public static void main(String[] args) {
//        int[] input =new int[]{1, 2, 2};
        int[] input =new int[]
                {2, 4, 2, 6, 1, 7, 8, 9, 2, 1};
        System.out.println(candies(10, input));
    }

}


