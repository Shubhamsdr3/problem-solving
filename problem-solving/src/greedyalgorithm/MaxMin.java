package greedyalgorithm;

import java.util.Arrays;

public class MaxMin {

    // Complete the maxMin function below.
    private static int maxMin(int k, int[] arr) {
        Arrays.sort(arr);

        int unfairness = Integer.MAX_VALUE;
        int i =0;
        int j = k -1;
        while (j < arr.length) {
            int diff = arr[j] - arr[i];
            if (diff < unfairness) {
                unfairness = diff;
            }
            i++;
            j++;
        }
        return unfairness;
    }

    public static void main(String[] args) {
        int n = 7;
        int lengthOfSubArray = 3;
        int[] inputArray = new int[]{10, 100, 300, 200, 1000, 20, 30};

        int lengthOfSubArray1 = 4;
        int[] inputArray1 = new int[]{1, 2, 3, 4, 10, 20, 30, 40, 100, 200};
        System.out.println(maxMin(lengthOfSubArray, inputArray));

    }
}
