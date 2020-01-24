package implementation;

import java.util.Arrays;

public class CircularArrayRotation {

    private static int[] circularArrayRotation(int[] a, int k, int[] queries) {
        swapElements(a, k);
        int[] result = new int[queries.length];
        for (int m = 0; m < queries.length; m++) {
            result[m] = a[queries[m]];
        }
        return result;
    }

    private static void swapElements(int[] arr, int k) {
        while (k > 0) {
            int temp = arr[arr.length -1];
            for (int i= arr.length-1; i > 0; i--) {
                arr[i] = arr[i-1];
            }
            arr[0] = temp;
            k--;
        }
    }

    public static void main(String[] args) {
        int rotationCount = 2;
        int[] arr = new int[]{1, 2, 3};
        int[] queries = new int[]{0, 1, 2};

        int rotationCount1 = 2;
        int[] arr1 = new int[]{3, 4, 5};
        int[] queries1 = new int[]{1, 2};
        System.out.println(Arrays.toString(circularArrayRotation(arr1, rotationCount1, queries1)));
    }
}
