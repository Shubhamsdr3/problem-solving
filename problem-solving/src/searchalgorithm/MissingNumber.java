package searchalgorithm;

import java.util.*;

public class MissingNumber {

    // Complete the missingNumbers function below.
    private static Set<Integer> missingNumbers(int[] arr, int[] brr) {

        Set<Integer> result = new TreeSet<>();
        Arrays.sort(arr);
        Arrays.sort(brr);
        int i = 0;
        for (int j = 0; j < brr.length - 1; j++) {
            if (brr[j] != arr[i]) {
                result.add(brr[j]);
            } else {
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] firstArray = new int[]{203, 204, 205, 206, 207, 208, 203, 204, 205, 206};
        int[] secondArray = new int[]{203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204};

        int[] firstArray1 = new int[]{11, 4, 11, 7, 13, 4, 12, 11, 10, 14};
        int[] secondArray1 = new int[]{11, 4, 11, 7, 3, 7, 10, 13, 4, 8, 12, 11, 10, 14, 12};

        Set<Integer> result = missingNumbers(firstArray1, secondArray1);
        System.out.println(result);
    }

}
